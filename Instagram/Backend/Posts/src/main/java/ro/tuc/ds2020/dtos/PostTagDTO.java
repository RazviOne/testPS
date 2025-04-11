package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PostTagDTO extends RepresentationModel<PostTagDTO> {

    private Integer idPostTag;
    @NotNull
    private Integer idPost;
    @NotNull
    private Integer idTag;

    public PostTagDTO() {}

    public PostTagDTO(Integer idPostTag, Integer idPost, Integer idTag) {
        this.idPostTag = idPostTag;
        this.idPost = idPost;
        this.idTag = idTag;
    }

    public PostTagDTO(Integer idPost, Integer idTag) {
        this.idPost = idPost;
        this.idTag = idTag;
    }

    public Integer getIdPostTag() {
        return idPostTag;
    }

    public void setIdPostTag(Integer idPostTag) {
        this.idPostTag = idPostTag;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagDTO tagDTO = (PostTagDTO) o;
        return this.idPostTag == tagDTO.idPostTag &&
                Objects.equals(this.idPost, tagDTO.idPost) &&
                Objects.equals(this.idTag, tagDTO.idTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idPostTag, this.idPost, this.idTag);
    }

}
