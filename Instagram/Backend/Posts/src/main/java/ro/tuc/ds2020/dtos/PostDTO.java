package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class PostDTO extends RepresentationModel<PostDTO> {

    private Integer idPost;
    @NotNull
    private Integer idPerson;
    private Integer idParent;
    private Integer idTag;
    @NotNull
    private String title;
    @NotNull
    private String text;
    @NotNull
    private LocalDateTime dateCreated;
    @NotNull
    private String status;
    private byte[] image;
    @NotNull
    private Integer totalVotes;
    @NotNull
    private Boolean noMoreComments;


    public PostDTO() {
    }

    public PostDTO(Integer idPost, Integer idPerson, Integer idParent, Integer idTag, String title, String text,
                   LocalDateTime dateCreated, String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
        this.idPost = idPost;
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

    public PostDTO(Integer idPerson, Integer idParent, Integer idTag, String title, String text,
                   LocalDateTime dateCreated, String status, byte[] image, Integer totalVotes, Boolean noMoreComments) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return this.idPost == postDTO.idPost &&
                Objects.equals(this.idPerson, postDTO.idPerson) &&
                Objects.equals(this.idParent, postDTO.idParent) &&
                Objects.equals(this.idTag, postDTO.idTag) &&
                Objects.equals(this.title, postDTO.title) &&
                Objects.equals(this.text, postDTO.text) &&
                Objects.equals(this.dateCreated, postDTO.dateCreated) &&
                Objects.equals(this.status, postDTO.status) &&
                Arrays.equals(this.image, postDTO.image) &&
                Objects.equals(this.totalVotes, postDTO.totalVotes) &&
                Objects.equals(this.noMoreComments, postDTO.noMoreComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idPost, this.idPerson, this.idParent, this.idTag, this.title, this.text,
                this.dateCreated, this.status, Arrays.hashCode(this.image), this.totalVotes, this.noMoreComments);
    }

}
