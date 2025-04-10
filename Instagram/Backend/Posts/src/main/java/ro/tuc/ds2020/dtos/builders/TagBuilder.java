package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.TagDTO;
import ro.tuc.ds2020.entities.Tag;

public class TagBuilder {

    private TagBuilder() {}

    public static TagDTO toTagDTO(Tag tag) {
        return new TagDTO(tag.getIdTag(), tag.getName());
    }
    public static Tag toEntity(TagDTO dto) {
        return new Tag(dto.getName());
    }
}
