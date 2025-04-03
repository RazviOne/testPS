package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;
import ro.tuc.ds2020.entities.Post;

public class PostBuilder {

    private PostBuilder() {
    }

    public static PostDTO toPostDTO(Post post) {
        return new PostDTO(post.getIdPost(), post.getIdPerson(), post.getTitle(), post.getText(), post.getDateCreated(),
                post.getStatus(), post.getImage(), post.getTotalVotes(), post.getIdParent());
    }

    public static PostDetailsDTO toPostDetailsDTO(Post post) {
        return new PostDetailsDTO(post.getIdPost(), post.getIdPerson(), post.getTitle(), post.getText(),
                post.getDateCreated(), post.getStatus(), post.getImage(), post.getTotalVotes(), post.getIdParent());
    }

    public static Post toEntity(PostDetailsDTO postDetailsDTO) {
        return new Post(postDetailsDTO.getIdPerson(), postDetailsDTO.getTitle(), postDetailsDTO.getText(),
                postDetailsDTO.getDateCreated(), postDetailsDTO.getStatus(), postDetailsDTO.getImage(),
                postDetailsDTO.getTotalVotes(), postDetailsDTO.getIdParent());
    }

}
