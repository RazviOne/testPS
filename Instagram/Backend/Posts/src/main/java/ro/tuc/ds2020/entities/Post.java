package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    @Column(name = "idPerson", nullable = false)
    private Integer idPerson;

    @Column(name = "idParent", nullable = true)
    private Integer idParent;

    @Column(name = "idTag", nullable = true)
    private Integer idTag;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "dateCreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "status", nullable = false)
    private String status;

    @Lob
    @Column(name = "image", nullable = true)
    private byte[] image;

    @Column(name = "totalVotes", nullable = false)
    private Integer totalVotes;

    @Column(name = "noMoreComments", nullable = false)
    private Boolean noMoreComments;

    public Post() {
    }

    public Post(Integer idPerson, Integer idParent, Integer idTag, String title, String text, LocalDateTime dateCreated,
                String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
        this.idPerson = idPerson;
        this.idParent = idParent;
        this.idTag = idTag;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
        this.noMoreComments = noMoreComments;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Boolean getNoMoreComments() {
        return noMoreComments;
    }

    public void setNoMoreComments(Boolean noMoreComments) {
        this.noMoreComments = noMoreComments;
    }

}
