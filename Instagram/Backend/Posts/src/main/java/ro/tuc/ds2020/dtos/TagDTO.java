package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TagDTO extends RepresentationModel<TagDTO> {

    private Integer idTag;
    @NotNull
    private String name;

    public TagDTO() {}

    public TagDTO(Integer idTag, String name) {
        this.idTag = idTag;
        this.name = name;
    }

    public TagDTO(String name) {
        this.name = name;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDTO tagDTO = (TagDTO) o;
        return this.idTag == tagDTO.idTag &&
                Objects.equals(this.name, tagDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idTag, this.name);
    }

}
