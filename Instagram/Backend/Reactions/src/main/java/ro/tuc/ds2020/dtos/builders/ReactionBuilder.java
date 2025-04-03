package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;
import ro.tuc.ds2020.entities.Post;

public class ReactionBuilder() {
    private ReactionBuilder() {

    }

    public static ReactionDTO toReactionDTO(Reaction reaction){
        return new ReactionDTO(
                reaction.getIdReaction(),
                reaction.getIdPerson(),
                reaction.getIdComment(),
                reaction.getIdPost(),
                reaction.isLiked()
        );
    }

    public static Reaction toEntity(ReactionDTO reactionDTO) {
        return new Reaction(
                reactionDTO.getIdReaction(),
                reactionDTO.getIdPerson(),
                reactionDTO.getIdComment(),
                reactionDTO.getIdPost(),
                reactionDTO.isLiked()
        );
    }
}