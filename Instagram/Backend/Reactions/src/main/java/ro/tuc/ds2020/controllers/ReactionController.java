package src.main.java.ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ReactionDTO;
import src.main.java.ro.tuc.ds2020.services.ReactionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    @Autowired
    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    // Get all reactions for a post
    @GetMapping("/post/{postID}")
    public ResponseEntity<List<ReactionDTO>> getPostReactions(@PathVariable Integer postID) {
        try {
            return new ResponseEntity<>(reactionService.getPostReactions(postID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all reactions for a comment
    @GetMapping("/comment/{commentID}")
    public ResponseEntity<List<ReactionDTO>> getCommentReactions(@PathVariable Integer commentID) {
        try {
            return new ResponseEntity<>(reactionService.getCommentReactions(commentID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get like count for a post
    @GetMapping("/post/{postID}/likes")
    public ResponseEntity<Integer> getPostLikedCount(@PathVariable Integer postID) {
        Integer likeCount = reactionService.getPostLikeCount(postID);
        return ResponseEntity.ok(likeCount);
    }

    // Get like count for a comment
    @GetMapping("/comment/{commentID}/likes")
    public ResponseEntity<Integer> getCommentLikedCount(@PathVariable Integer commentID) {
        Integer likeCount = reactionService.getCommentLikeCount(commentID);
        return ResponseEntity.ok(likeCount);
    }

    // Add a new reaction
    @PostMapping()
    public ResponseEntity<Void> addReaction(@Valid @RequestBody ReactionDTO reactionDTO) {
        try {
            reactionService.addReaction(reactionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Update a reaction completely
    @PutMapping("/{reactionID}")
    public ResponseEntity<Void> updateReaction(@PathVariable Integer reactionID, @Valid @RequestBody ReactionDTO reactionDTO) {
        try {
            reactionService.updateReaction(reactionID, reactionDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Delete a reaction
    @DeleteMapping("/{idReaction}")
    public ResponseEntity<String> deleteReaction(@PathVariable Integer idReaction) {
        try {
            reactionService.deleteReaction(idReaction);
            return new ResponseEntity<>("Reaction deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update like status only
    @PatchMapping("/{idReaction}/like-status")
    public ResponseEntity<String> updateReactionLikeStatus(@PathVariable Integer idReaction, @RequestParam boolean isLiked) {
        try {
            reactionService.updateReactionLikeStatus(idReaction, isLiked);
            return new ResponseEntity<>("Reaction like status updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
