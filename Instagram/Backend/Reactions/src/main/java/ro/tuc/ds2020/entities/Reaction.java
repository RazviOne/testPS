package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Reaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReaction;

    private Integer idPerson;

    private Integer idComment;

    private Integer idPost;

    private boolean isLiked;

    public Reaction() {

    }
    public Reaction(Integer idReaction, Integer idPerson, Integer idComment, Integer idPost, boolean isLiked) {
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