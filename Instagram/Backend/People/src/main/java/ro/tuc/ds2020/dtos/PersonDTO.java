package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class PersonDTO extends RepresentationModel<PersonDTO> {

    private Integer idPerson;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Integer userScore;
    @NotNull
    private Boolean isAdmin;
    @NotNull
    private Boolean isBanned;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    private LocalDateTime birthDate;
    private String homeCity;


    public PersonDTO() {}

    public PersonDTO(Integer idPerson, String name, String username, String password, Integer userScore,
                     Boolean isAdmin, Boolean isBanned, String email, String phoneNumber, LocalDateTime birthDate,
                     String homeCity) {
        this.idPerson = idPerson;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userScore = userScore;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.homeCity = homeCity;
    }

    public PersonDTO(String name, String username, String password, Integer userScore,
                     Boolean isAdmin, Boolean isBanned, String email, String phoneNumber, LocalDateTime birthDate,
                     String homeCity) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userScore = userScore;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.homeCity = homeCity;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Boolean isBanned) {
        this.isBanned = isBanned;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return this.idPerson == personDTO.idPerson &&
                Objects.equals(this.name, personDTO.name) &&
                Objects.equals(this.username, personDTO.username) &&
                Objects.equals(this.password, personDTO.password) &&
                Objects.equals(this.userScore, personDTO.userScore) &&
                Objects.equals(this.isAdmin, personDTO.isAdmin) &&
                Objects.equals(this.isBanned, personDTO.isBanned) &&
                Objects.equals(this.email, personDTO.email) &&
                Objects.equals(this.phoneNumber, personDTO.phoneNumber) &&
                Objects.equals(this.birthDate, personDTO.birthDate) &&
                Objects.equals(this.homeCity, personDTO.homeCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.username, this.password, this.userScore, this.isAdmin,
                this.isBanned, this.email, this.phoneNumber, this.birthDate, homeCity);
    }

}
