package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.entities.Post;

public class PostBuilder {

    private PostBuilder() {
    }

    public static PostDTO toPostDTO(Post post) {
        return new PostDTO(
                post.getIdPost(),
                post.getIdPerson(),
                post.getIdParent(),
                post.getIdTag(),
                post.getTitle(),
                post.getText(),
                post.getDateCreated(),
                post.getStatus(),
                post.getImage(),
                post.getTotalVotes(),
                post.getNoMoreComments()
        );
    }

    public static Post toEntity(PostDTO dto) {
        return new Post(
                dto.getIdPerson(),
                dto.getIdParent(),
                dto.getIdTag(),
                dto.getTitle(),
                dto.getText(),
                dto.getDateCreated(),
                dto.getStatus(),
                dto.getImage(),
                dto.getTotalVotes(),
                dto.getNoMoreComments()
        );
    }

}
