package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

public class ReactionDTO extends RepresentationModel<ReactionDTO> {
    private Integer idReaction;
    private Integer idPerson;
    private Integer idComment;
    private Integer idPost;
    private boolean isLiked;

    public ReactionDTO(Integer idReaction, Integer idPerson, Integer idComment, Integer idPost, boolean isLiked) {
        this.idReaction = idReaction;
        this.idPerson = idPerson;
        this.idComment = idComment;
        this.idPost = idPost;
        this.isLiked = isLiked;
    }

    public Integer getIdReaction() {
        return idReaction;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}