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
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")  // 🔁 update de la "/person"
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
                    .getPostById(dto.getId())).withRel("postDetails");
            dto.add(postLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertPost(@Valid @RequestBody PostDetailsDTO postDTO) {
        Integer postId = postService.insert(postDTO);
        return new ResponseEntity<>(postId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDetailsDTO> getPostById(@PathVariable("id") Integer postId) {
        try {
            PostDetailsDTO dto = postService.findPostById(postId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDetailsDTO> updatePost(@Valid @RequestBody PostDetailsDTO postDetailsDTO,
                                                     @PathVariable("id") Integer postId) {
        try {
            postService.findPostById(postId); // verifică dacă există
            postService.update(postId, postDetailsDTO);
            return new ResponseEntity<>(postDetailsDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer postId) {
        try {
            postService.findPostById(postId);
            postService.delete(postId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
