package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostTagDTO;
import ro.tuc.ds2020.entities.Post;
import ro.tuc.ds2020.services.PostService;
import ro.tuc.ds2020.services.PostTagService;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;
    private final PostTagService postTagService;

    @Autowired
    public PostController(PostService postService, PostTagService postTagService) {
        this.postService = postService;
        this.postTagService = postTagService;
    }

    @GetMapping()
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<PostDTO> dtos = postService.findPosts();
        for (PostDTO dto : dtos) {
            Link postLink = linkTo(methodOn(PostController.class)
                    .getPostById(dto.getIdPost())).withRel("postDetails");
            dto.add(postLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertPost(@Valid @RequestBody PostDTO postDTO) {
        Integer idPost = postService.insert(postDTO);
        return new ResponseEntity<>(idPost, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Integer idPost) {
        PostDTO failedDTO = new PostDTO();
        failedDTO.setIdPost(-1);
        try {
            PostDTO dto = postService.findPostById(idPost);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO,
                                              @PathVariable("id") Integer idPost) {
        PostDTO failedDTO = new PostDTO();
        failedDTO.setIdPost(-1);
        try {
            postService.findPostById(idPost);
            postDTO.setIdPost(idPost);
            postService.update(postDTO);
            return new ResponseEntity<>(postDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDTO> deletePost(@PathVariable("id") Integer idPost) {
//        System.out.println("Sterge post/comment cu id: " + idPost);
        PostDTO failedDTO = new PostDTO();
        failedDTO.setIdPost(-1);
        try {
            PostDTO dto = postService.findPostById(idPost);
            postService.delete(idPost);

            // Database Syncronization
            try {
                // Delete all Reactions that are from the deleted Post/Comment
                URL url = new URL("http://localhost:8082/reactions/post/" + idPost);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                System.out.print("Status: " + connection.getResponseCode() + "\n");
                connection.disconnect();
//                System.out.println("A sters reactiile");
            } catch (Exception ignored) {}

            // Delete all PostTags that are used in the deleted Post
            List<PostTagDTO> postTagDTOList =  postTagService.findPostTags();
            for(PostTagDTO postTagDTO : postTagDTOList) {
                if(postTagDTO.getIdPost().equals(idPost)) {
//                    System.out.println("A gasit post tag cu id: " + postTagDTO.getIdPostTag());
                    postTagService.delete(postTagDTO.getIdPostTag());
                }
            }
//            System.out.println("A sters post tag-urile");

            // Delete all Comments from the deleted Post/Comment
            List<PostDTO> postDTOList = postService.findPosts();
            for(PostDTO postDTO : postDTOList) {
                if(postDTO.getIdParent() != null) {
                    if (postDTO.getIdParent().equals(idPost)) {
//                        System.out.println("A gasit comment cu id: " + postDTO.getIdPost());
                        deletePost(postDTO.getIdPost());
                    }
                }
            }
//            System.out.println("A sters comment-urile");

            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(failedDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<String> deletePostsFromPerson(@PathVariable("id") Integer idPerson) {
        List<PostDTO> postDTOList = postService.findPosts();
        for (PostDTO postDTO : postDTOList) {
            if(postDTO.getIdPerson().equals(idPerson)) {
                deletePost(postDTO.getIdPost());
            }
        }

        return new ResponseEntity<>("Deleted all posts from person with idPerson : " + idPerson, HttpStatus.OK);
    }

}
