package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;
import ro.tuc.ds2020.services.PostService;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
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
    public ResponseEntity<Integer> insertPost(@Valid @RequestBody PostDetailsDTO postDTO) {
        Integer postID = postService.insert(postDTO);
        return new ResponseEntity<>(postID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDetailsDTO> getPostById(@PathVariable("id") Integer postId) {
        PostDetailsDTO failedDto = new PostDetailsDTO();
        failedDto.setIdPost(-1);
        try {
            PostDetailsDTO dto = postService.findPostById(postId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<PostDetailsDTO> updatePost(@Valid @RequestBody PostDetailsDTO postDetailsDTO,
                                                       @PathVariable("id") Integer postId){
        PostDetailsDTO failedDto = new PostDetailsDTO();
        failedDto.setIdPost(-1);
        try {
            postService.findPostById(postId);
            postService.update(postId, postDetailsDTO);
            return new ResponseEntity<>(postDetailsDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDetailsDTO> deletePost(@PathVariable("id") Integer postId){
        PostDetailsDTO failedDto = new PostDetailsDTO();
        failedDto.setIdPost(-1);
        try {
            PostDetailsDTO dto = postService.findPostById(postId);
            postService.delete(postId);

//            try {
//                URL url = new URL("http://localhost:8081/deviceLink/post/" + postId);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("DELETE");
//                int status = connection.getResponseCode();
//                System.out.print("Status: " + status + "\n");
//                return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
//            } catch (Exception e){
                return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
//            }
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

}
