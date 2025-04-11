package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {

//    Optional<Tag> findByName(String name);

}
