package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * Example: JPA generate Query by Field
     */
//    List<Person> findByName(String name);

    /**
     * Example: Write Custom Query
     */
//    @Query(value =
//            "SELECT p " +
//            "FROM Person p " +
//            "WHERE p.name = :name " +
//            "AND p.age >= 60")
//    Optional<Person> findSeniorsByName(@Param("name") String name);

//    @Modifying
//    @Query(value =
//            "UPDATE Person p " +
//            "SET p.name = :name, p.address = :address, p.age = :age, p.admin = :admin " +
//            "WHERE p.id = :id")
//    void updatePerson(@Param("id") String id,
//                      @Param("name") String name,
//                      @Param("address") String address,
//                      @Param("age") int age,
//                      @Param("admin") Boolean admin);

    @Query(value =
            "SELECT p " +
            "FROM Person p " +
            "WHERE p.isAdmin = true")
    List<Person> findAdminUsers();

//    @Query(value =
//            "SELECT p " +
//            "FROM Person p " +
//            "WHERE p.isAdmin = true")
//    List<Person> findByUsername();
    Optional<Person> findByUsername(@Param("username") String username);
}
