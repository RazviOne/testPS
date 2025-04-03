package ro.tuc.ds2020.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.Date;

@Entity
public class Post implements Serializable{
=======
import java.time.LocalDateTime;

@Entity
public class Post  implements Serializable{

//    private static final long serialVersionUID = 1L;
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

<<<<<<< HEAD
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
=======
    private Integer idPerson;

    @Column(length = 255)
    private String title;

    @Column(length = 255)
    private String text;

    private LocalDateTime dateCreated;

    @Column(length = 255)
    private String status;

    @Lob
    private byte[] image;

    private Integer totalVotes;

    private Boolean noMoreComments;
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501

    public Post() {
    }

<<<<<<< HEAD
    public Post(Integer idPerson, String title, String text, Date dateCreated, String status, Byte[] image, Integer totalVotes, Integer idParent) {
=======
    public Post(Integer idPerson, String title, String text, LocalDateTime dateCreated,
                String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
        this.idPerson = idPerson;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
<<<<<<< HEAD
        this.idParent = idParent;
=======
        this.noMoreComments = noMoreComments;
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
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

<<<<<<< HEAD
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
=======
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

<<<<<<< HEAD
    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
=======
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
        this.image = image;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

<<<<<<< HEAD
    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }
    
=======
    public Boolean getNoMoreComments() {
        return noMoreComments;
    }

    public void setNoMoreComments(Boolean noMoreComments) {
        this.noMoreComments = noMoreComments;
    }

>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
}
