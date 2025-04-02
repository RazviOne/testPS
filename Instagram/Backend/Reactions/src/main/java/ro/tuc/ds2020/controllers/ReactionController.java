package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;
import ro.tuc.ds2020.services.PostService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/reactions")
public class ReactionController() {
    private final ReactionService reactionService;

    @Autowired
    public ReactionController(ReactionService reactionService) {

        this.reactionService = reactionService;
    }

    @GetMapping()
    public ResponseEntity<List<ReactionDTO>> getPostReactions(@PathVariable Integer postID){
        try {
            return new ResponseEntity<List<ReactionDTO>>(reactionService.getPostReactions(postID), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<ReactionDTO>> getCommentReactions(@PathVariable Integer commentID){
        try{
            return new ResponseEntity<List<ReactionDTO>>(reactionService.getCommentReactions(commentID), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<Integer> getPostLikedCount(@PathVariable Integer postID){
        Integer likeCount = reactionService.getPostLikeCount(postID);
        return ResponseEntity.ok(likeCount);
    }

    @GetMapping()
    public ResponseEntity<Integer> getCommentLikedCount(@PathVariable Integer commentID){
        Integer likeCount = reactionService.getCommentLikeCount(commentID);
        return ResponseEntity.ok(likeCount);
    }


    @PostMapping()
    public ResponseEntity<Void> addReaction(@Valid @RequestBody ReactionDTO reactionDTO) {
        try {
            reactionService.addReaction(reactionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping()
    public ResponseEntity<Void> updateReaction(@PathVariable Integer reactionID, @Valid @RequestBody ReactionDTO reactionDTO){
        try {
            reactionService.updateReaction(reactionID, reactionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteReaction(@PathVariable Integer idReaction) {
        try {
            reactionService.deleteReaction(idReaction);
            return new ResponseEntity<>("Reaction deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping()
    public ResponseEntity<String> updateReactionLikeStatus(@PathVariable Integer idReaction, @RequestParam boolean isLiked) {
        try {
            // Call service to update the reaction's 'isLiked' status
            reactionService.updateReactionLikeStatus(idReaction, isLiked);
            return new ResponseEntity<>("Reaction like status updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}