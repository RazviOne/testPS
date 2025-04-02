package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

public class PostDTO extends RepresentationModel<PostDTO> {
    private Integer idPost;
    private String title;
    private String status;
    private Integer totalVotes;

    public PostDTO() {
    }

    public PostDTO(Integer idPost, String title, String status, Integer totalVotes) {
        this.idPost = idPost;
        this.title = title;
        this.status = status;
        this.totalVotes = totalVotes;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Integer getId() {
        return this.idPost;
    }
}
