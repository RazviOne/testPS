package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.dtos.validators.annotation.AgeLimit;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PersonDetailsDTO {

    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @AgeLimit(limit = 18)
    private int age;
    @NotNull
    private Boolean isAdmin;


    public PersonDetailsDTO() {
    }

    public PersonDetailsDTO(String username, String password, String name, String address, int age, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public PersonDetailsDTO(Integer id, String username, String password, String name, String address, int age,
                            Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        PersonDetailsDTO that = (PersonDetailsDTO) o;
        return this.age == that.age &&
                Objects.equals(this.username, that.username) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.isAdmin, that.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.password, this.name, this.address, this.age, this.isAdmin);
    }

}
