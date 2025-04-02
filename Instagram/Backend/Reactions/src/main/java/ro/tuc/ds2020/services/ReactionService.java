package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.TagDTO;
import ro.tuc.ds2020.dtos.builders.TagBuilder;
import ro.tuc.ds2020.entities.Tag;
import ro.tuc.ds2020.repositories.TagRepository;

import java.util.List;
import java.util.stream.Collectors;


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
}
