package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Reaction;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer>{
    // Query to get all reactions of a POST
    @Query(value = "SELECT * FROM instagram-reactions WHERE idPost = :postID", nativeQuery = true)
    List<Reaction> findReactionsByPostId(@Param("postID") Integer postID);

    // Query to get all reactions of a COMMENT
    @Query(value = "SELECT * FROM instagram-reactions WHERE idComment = :commentID", nativeQuery = true)
    List<Reaction> findReactionsByCommentId(@Param("commentID") Integer commentID);

    // Query to get the number of upvotes of a POST (isLiked - !isLiked)
    @Query(value = "SELECT (SUM(CASE WHEN isLiked = true THEN 1 ELSE -1 END)) FROM instagram-reactions WHERE idPost = :postID", nativeQuery = true)
    Integer getPostLikeCount(@Param("postID") Integer postID);

    @Query(value = "SELECT (SUM(CASE WHEN isLiked = true THEN 1 ELSE -1 END)) FROM instagram-reactions WHERE idComment = :commentID", nativeQuery = true)
    Integer getCommentLikeCount(@Param("commentID") Integer commentID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO instagram-reactions (idPerson, idComment, idPost, isLiked) VALUES (:idPerson, :idComment, :postID, :isLiked)", nativeQuery = true)
    void addReaction(@Param("idPerson") Integer idPerson, @Param("idComment") Integer idComment, @Param("postID") Integer postID, @Param("isLiked") Boolean isLiked);

    Optional<Reaction> findByIdReaction(Integer idReaction);
}