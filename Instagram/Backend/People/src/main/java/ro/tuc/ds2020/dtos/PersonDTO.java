package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class PersonDTO extends RepresentationModel<PersonDTO> {
    private Integer id;
    private String username;
    private String password;
    private Boolean isAdmin;


    public PersonDTO() {
    }

    public PersonDTO(Integer id, String username, String password, Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return this.username == personDTO.username &&
                Objects.equals(this.password, personDTO.password) &&
                Objects.equals(this.isAdmin, personDTO.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.password, this.isAdmin);
    }

}
