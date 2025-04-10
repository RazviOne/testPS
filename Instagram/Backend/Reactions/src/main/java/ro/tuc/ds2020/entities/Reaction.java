package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Reaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReaction;

    @Column(name = "idPerson", nullable = false)
    private Integer idPerson;

    @Column(name = "idPost", nullable = false)
    private Integer idPost;

    @Column(name = "isLiked", nullable = false)
    private Boolean isLiked;

    public Reaction() {}

    public Reaction(Integer idPerson, Integer idPost, Boolean isLiked) {
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

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

}