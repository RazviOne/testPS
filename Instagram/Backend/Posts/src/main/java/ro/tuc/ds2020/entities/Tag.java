package ro.tuc.ds2020.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    public Tag() {}
    public Tag(Integer id) {this.id = id;}
    public Tag(String name) {this.name = name;}
    public Tag(Integer id, String name) {this.id = id;this.name = name;}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
