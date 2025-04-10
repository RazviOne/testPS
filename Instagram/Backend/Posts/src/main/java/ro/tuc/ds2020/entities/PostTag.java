package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PostTag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPostTag;

    @Column(name = "idPost", nullable = false)
    private Integer idPost;

    @Column(name = "idTag", nullable = false)
    private Integer idTag;

    public PostTag() {}

    public PostTag(Integer idPost, Integer idTag) {
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

}
