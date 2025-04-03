package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class PostDTO extends RepresentationModel<PostDTO> {
    private Integer idPost;
    private Integer idPerson;
    private String title;
    private String text;
    private Date dateCreated;
    private String status;
    private Byte[] image;
    private Integer totalVotes;
    private Integer idParent;
=======
public class PostDTO extends RepresentationModel<PostDTO> {
    private Integer idPost;
    private String title;
    private String status;
    private Integer totalVotes;
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501

    public PostDTO() {
    }

<<<<<<< HEAD
    public PostDTO(Integer idPost, Integer idPerson, String title, String text, Date dateCreated, String status,
                   Byte[] image, Integer totalVotes, Integer idParent) {
        this.idPost = idPost;
        this.idPerson = idPerson;
        this.title = title;
        this.dateCreated = dateCreated;
        this.status = status;
        this.image = image;
        this.totalVotes = totalVotes;
        this.idParent = idParent;
=======
    public PostDTO(Integer idPost, String title, String status, Integer totalVotes) {
        this.idPost = idPost;
        this.title = title;
        this.status = status;
        this.totalVotes = totalVotes;
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

<<<<<<< HEAD
    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

=======
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

<<<<<<< HEAD
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

=======
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
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
        this.image = image;
    }

=======
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return this.idPost == postDTO.idPost &&
                Objects.equals(this.idPerson, postDTO.idPerson) &&
                Objects.equals(this.title, postDTO.title) &&
                Objects.equals(this.text, postDTO.text) &&
                Objects.equals(this.dateCreated, postDTO.dateCreated) &&
                Objects.equals(this.status, postDTO.status) &&
                Arrays.equals(this.image, postDTO.image) &&
                Objects.equals(this.totalVotes, postDTO.totalVotes) &&
                Objects.equals(this.idParent, postDTO.idParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idPost, this.idPerson, this.title, this.text, this.dateCreated, this.status,
                Arrays.hashCode(this.image), this.totalVotes, this.idParent);
    }

=======
    public Integer getId() {
        return this.idPost;
    }
>>>>>>> 03e97e513a0b27cae2f52810fd38e2d4f6e37501
}
