package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.dtos.validators.annotation.AgeLimit;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class PostDetailsDTO {

    private Integer idPost;
    private Integer idPerson;
    private String title;
    private String text;
    private LocalDateTime dateCreated;
    private String status;
    private byte[] image;
    private Integer totalVotes;
    private Boolean noMoreComments;


    public PostDetailsDTO() {
    }

    public PostDetailsDTO(Integer idPost, Integer idPerson, String title, String text,
                          LocalDateTime dateCreated, String status, byte[] image,
                          Integer totalVotes, Boolean noMoreComments) {
        this.idPost = idPost;
        this.idPerson = idPerson;
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
