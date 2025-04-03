package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PostBuilder;
import ro.tuc.ds2020.entities.Post;
import ro.tuc.ds2020.repositories.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;


    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> findPosts() {
        List<Post> postList = postRepository.findAll();
        return postList.stream()
                .map(PostBuilder::toPostDTO)
                .collect(Collectors.toList());
    }

//    public List<PostDTO> findAdmins() {
//        List<Person> personList = personRepository.findAdminUsers();
//        return personList.stream()
//                .map(PersonBuilder::toPersonDTO)
//                .collect(Collectors.toList());
//    }

    public PostDetailsDTO findPostById(Integer id) {
        Optional<Post> prosumerOptional = postRepository.findById(id);

        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Post with id {} was not found in db", id);
            throw new ResourceNotFoundException(Post.class.getSimpleName() + " with id: " + id);
        }
        return PostBuilder.toPostDetailsDTO(prosumerOptional.get());
    }

    public Integer insert(PostDetailsDTO postDTO) {
        Post post = PostBuilder.toEntity(postDTO);
        post = postRepository.save(post);
        LOGGER.debug("Post with id {} was inserted in db", post.getIdPost());
        return post.getIdPost();
    }

    public void update(Integer id, PostDetailsDTO postDetailsDTO) {
        Post post = PostBuilder.toEntity(postDetailsDTO);
        post.setIdPost(id);
        postRepository.save(post);
        LOGGER.debug("Post with id {} was updated in db", post.getIdPost());
    }

    public void delete(Integer id){
        postRepository.deleteById(id);
    }

//    public PostDetailsDTO authenticateUser(String username, String password){
//        Optional<Post> post = postRepository.findByUsername(username);
//
//        if(post.isPresent()) {
//            if(password.equals(post.get().getPassword())) {
//                return PostBuilder.toPostDetailsDTO(post.get());
//            }
//            else{
//                return null;
//            }
//        }
//        return null;
//    }

}
