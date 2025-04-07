package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ReactionDTO;
import ro.tuc.ds2020.dtos.builders.ReactionBuilder;
import ro.tuc.ds2020.repositories.ReactionRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class ReactionService() {
    private final ReactionRepository reactionRepository;

    @Autowired
    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<ReactionDTO> getPostReactions(Integer postID) {
        return reactionRepository.getPostReactions(postID)
                .map(ReactionBuilder::toReactionDTO)
                .orElseThrow(() -> new RuntimeException("Post's Reaction with Post ID " + id + " not found"));
    }
    public List<ReactionDTO> getCommentReactions(Integer commentID) {
        return reactionRepository.getCommentReactions(commentID)
                .map(ReactionBuilder::toReactionDTO)
                .orElseThrow(() -> new RuntimeException("Comment's Reaction with Comment ID " + id + " not found"));
    }
    public Integer getPostLikeCount(Integer postID) {
        Integer count = reactionRepository.getPostLikeCount(postID);
        return count != null ? count : 0;
    }

    public Integer getCommentLikeCount(Integer commentID) {
        Integer count = reactionRepository.getCommentLikeCount(commentID);
        return count != null ? count : 0;
    }


    public void addReaction(ReactionDTO reactionDTO) {
        reactionRepository.addReactionToComment(
                reactionDTO.getIdPerson(),
                reactionDTO.getIdComment,
                reactionDTO.getIdPost,
                reactionDTO.isLiked()
        );
    }

    public ReactionDTO getReactionById(Integer reactionID) {
        Reaction reaction = reactionRepository.findById(reactionID)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + reactionID + " not found"));

        return ReactionBuilder.toReactionDTO(reaction);
    }

    public void updateReaction(Integer reactionID, ReactionDTO reactionDTO) {
        Reaction existingReaction = reactionRepository.findByIdReaction(reactionID)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + reactionID + " not found"));

        // Update fields with new data from ReactionDTO
        existingReaction.setLiked(reactionDTO.isLiked());

        // Save the updated reaction
        reactionRepository.save(existingReaction);
    }

    public void deleteReaction(Integer idReaction) {
        // Check if the reaction exists before trying to delete it
        if (!reactionRepository.existsById(idReaction)) {
            throw new RuntimeException("Reaction with ID " + idReaction + " not found");
        }

        // Perform the deletion
        reactionRepository.deleteById(idReaction);
    }


    public void updateReactionLikeStatus(Integer idReaction, boolean isLiked) {
        // Find the reaction by ID
        Reaction reaction = reactionRepository.findByIdReaction(idReaction)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + idReaction + " not found"));

        // Update the isLiked field
        reaction.setLiked(isLiked);

        // Save the updated reaction back to the database
        reactionRepository.save(reaction);
    }
}
