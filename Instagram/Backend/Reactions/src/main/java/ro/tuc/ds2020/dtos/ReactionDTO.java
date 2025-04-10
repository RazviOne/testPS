package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ReactionDTO extends RepresentationModel<ReactionDTO> {

    private Integer idReaction;
    @NotNull
    private Integer idPerson;
    @NotNull
    private Integer idPost;
    @NotNull
    private Boolean isLiked;

    public ReactionDTO() {}

    public ReactionDTO(Integer idReaction, Integer idPerson, Integer idPost, Boolean isLiked) {
        this.idReaction = idReaction;
        this.idPerson = idPerson;
        this.idPost = idPost;
        this.isLiked = isLiked;
    }

    public Integer getIdReaction() {
        return idReaction;
    }

    public void setIdReaction(Integer idReaction) {
        this.idReaction = idReaction;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean idLiked) {
        this.isLiked = idLiked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionDTO reactionDTO = (ReactionDTO) o;
        return this.idReaction == reactionDTO.idReaction &&
                Objects.equals(this.idPerson, reactionDTO.idPerson) &&
                Objects.equals(this.idPost, reactionDTO.idPost) &&
                Objects.equals(this.isLiked, reactionDTO.isLiked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idReaction, this.idPerson, this.idPost, this.isLiked);
    }

}