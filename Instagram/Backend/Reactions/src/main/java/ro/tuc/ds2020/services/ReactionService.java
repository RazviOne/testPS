package src.main.java.ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.dtos.ReactionDTO;
import ro.tuc.ds2020.entities.Reaction;
import src.main.java.ro.tuc.ds2020.dtos.builders.ReactionBuilder;
import src.main.java.ro.tuc.ds2020.repositories.ReactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;

    @Autowired
    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<ReactionDTO> getPostReactions(Integer postID) {
        List<Reaction> reactions = reactionRepository.findReactionsByPostId(postID);
        if (reactions.isEmpty()) {
            throw new RuntimeException("No reactions found for post with ID " + postID);
        }
        return reactions.stream().map(ReactionBuilder::toReactionDTO).collect(Collectors.toList());
    }

    public List<ReactionDTO> getCommentReactions(Integer commentID) {
        List<Reaction> reactions = reactionRepository.findReactionsByCommentId(commentID);
        if (reactions.isEmpty()) {
            throw new RuntimeException("No reactions found for comment with ID " + commentID);
        }
        return reactions.stream().map(ReactionBuilder::toReactionDTO).collect(Collectors.toList());
    }

    public Integer getPostLikeCount(Integer postID) {
        Integer count = reactionRepository.getPostLikeCount(postID);
        return count != null ? count : 0;
    }

    public Integer getCommentLikeCount(Integer commentID) {
        Integer count = reactionRepository.getCommentLikeCount(commentID);
        return count != null ? count : 0;
    }

    @Transactional
    public void addReaction(ReactionDTO reactionDTO) {
        reactionRepository.addReaction(
                reactionDTO.getIdPerson(),
                reactionDTO.getIdComment(),
                reactionDTO.getIdPost(),
                reactionDTO.isLiked()
        );
    }

    public ReactionDTO getReactionById(Integer reactionID) {
        Reaction reaction = reactionRepository.findById(reactionID)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + reactionID + " not found"));

        return ReactionBuilder.toReactionDTO(reaction);
    }

    @Transactional
    public void updateReaction(Integer reactionID, ReactionDTO reactionDTO) {
        Reaction existingReaction = reactionRepository.findByIdReaction(reactionID)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + reactionID + " not found"));

        existingReaction.setLiked(reactionDTO.isLiked());
        reactionRepository.save(existingReaction);
    }

    @Transactional
    public void deleteReaction(Integer idReaction) {
        if (!reactionRepository.existsById(idReaction)) {
            throw new RuntimeException("Reaction with ID " + idReaction + " not found");
        }
        reactionRepository.deleteById(idReaction);
    }

    @Transactional
    public void updateReactionLikeStatus(Integer idReaction, boolean isLiked) {
        Reaction reaction = reactionRepository.findByIdReaction(idReaction)
                .orElseThrow(() -> new RuntimeException("Reaction with ID " + idReaction + " not found"));

        reaction.setLiked(isLiked);
        reactionRepository.save(reaction);
    }
}
