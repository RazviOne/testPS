package ro.tuc.ds2020.dtos;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class PostDetailsDTO {

    @NotNull
    private Integer idPost;
    @NotNull
    private Integer idPerson;
    private String title;
    @NotNull
    private String text;
    @NotNull
    private Date dateCreated;
    @NotNull
    private String status;
    private Byte[] image;
    @NotNull
    private Integer totalVotes;
    private Integer idParent;


    public PostDetailsDTO() {
    }

    public PostDetailsDTO(Integer idPerson, String title, String text, Date dateCreated, String status,
                          Byte[] image, Integer totalVotes, Integer idParent) {
        this.idPerson = idPerson;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
        this.idParent = idParent;
    }

    public PostDetailsDTO(Integer idPost, Integer idPerson, String title, String text, Date dateCreated, String status,
                          Byte[] image, Integer totalVotes, Integer idParent) {
        this.idPost = idPost;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDetailsDTO that = (PostDetailsDTO) o;
        return Objects.equals(this.idPost, that.idPost) &&
                Objects.equals(this.idPerson, that.idPerson) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.text, that.text) &&
                Objects.equals(this.dateCreated, that.dateCreated) &&
                Objects.equals(this.status, that.status) &&
                Arrays.equals(this.image, that.image) &&
                Objects.equals(this.totalVotes, that.totalVotes) &&
                Objects.equals(this.idParent, that.idParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idPost, this.idPerson, this.title, this.text, this.dateCreated, this.status,
                Arrays.hashCode(this.image), this.totalVotes, this.idParent);
    }

}
