package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Tag;

import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer>{
    // Query to get all reactions of a POST
    @Query(value = "SELECT * FROM reactions WHERE idPost = :postID", nativeQuery = true)
    List<Reaction> findReactionsByPostId(@Param("postID") Integer postID);

    // Query to get all reactions of a COMMENT
    @Query(value = "SELECT * FROM reactions WHERE idComment = :commentID", nativeQuery = true)
    List<Reaction> findReactionsByCommentId(@Param("commentID") Integer commentID);

    // Query to get the number of upvotes of a POST (isLiked - !isLiked)
    @Query(value = "SELECT (SUM(CASE WHEN isLiked = true THEN 1 ELSE -1 END)) FROM reactions WHERE idPost = :postID", nativeQuery = true)
    Integer getPostLikeCount(@Param("postID") Integer postID);

    @Query(value = "SELECT (SUM(CASE WHEN isLiked = true THEN 1 ELSE -1 END)) FROM reactions WHERE idComment = :commentID", nativeQuery = true)
    Integer getCommentLikeCount(@Param("commentID") Integer commentID);
}