package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    @Id
    @Column(name = "idPerson", nullable = false)
    private Integer idPerson;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "image", nullable = true)
    private Byte[] image;

    @Column(name = "totalVotes", nullable = false)
    private Integer totalVotes;

    @Column(name = "idParent", nullable = true)
    private Integer idParent;

    public Post() {
    }

    public Post(Integer idPerson, String title, String text, Date dateCreated, String status, Byte[] image, Integer totalVotes, Integer idParent) {
        this.idPerson = idPerson;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
        this.idParent = idParent;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }
    
}
