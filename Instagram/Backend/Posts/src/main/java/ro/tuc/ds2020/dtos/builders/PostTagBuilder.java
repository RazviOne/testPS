package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PostTagDTO;
import ro.tuc.ds2020.entities.PostTag;

public class PostTagBuilder {

    private PostTagBuilder() {}

    public static PostTagDTO toPostTagDTO(PostTag postTag) {
        return new PostTagDTO(postTag.getIdPostTag(), postTag.getIdPost(), postTag.getIdTag());
    }
    public static PostTag toEntity(PostTagDTO dto) {
        return new PostTag(dto.getIdPost(), dto.getIdTag());
    }
}
