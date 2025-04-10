package ro.tuc.ds2020.dtos;

import jdk.vm.ci.meta.Local;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class PostDTO extends RepresentationModel<PostDTO> {

    private Integer idPost;
    private Integer idPerson;
    private Integer idParent;
    private String title;
    private String text;
    private LocalDateTime dateCreated;
    private String status;
    private byte[] image;
    private Integer totalVotes;
    private Boolean noMoreComments;


    public PostDTO() {
    }

    public PostDTO(Integer idPost, Integer idPerson, Integer idParent, String title, String text,
                   LocalDateTime dateCreated, String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
        this.idPost = idPost;
        this.idPerson = idPerson;
        this.idParent = idParent;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
        this.noMoreComments = noMoreComments;
    }

    public PostDTO(Integer idPerson, Integer idParent, String title, String text,
                   LocalDateTime dateCreated, String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
        this.idPerson = idPerson;
        this.idParent = idParent;
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
