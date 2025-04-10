package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.ReactionDTO;
import ro.tuc.ds2020.entities.Reaction;
import ro.tuc.ds2020.dtos.builders.ReactionBuilder;
import ro.tuc.ds2020.repositories.ReactionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactionService.class);
    private final ReactionRepository reactionRepository;

    @Autowired
    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<ReactionDTO> findReactions() {
        List<Reaction> reactionList = reactionRepository.findAll();
        return reactionList.stream()
                .map(ReactionBuilder::toReactionDTO)
                .collect(Collectors.toList());
    }

    public ReactionDTO findReactionById(Integer idReaction) {
        Optional<Reaction> prosumerOptional = reactionRepository.findById(idReaction);

        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Reaction with idReaction {} was not found in db", idReaction);
            throw new ResourceNotFoundException(Reaction.class.getSimpleName() + " with idReaction: " + idReaction);
        }
        return ReactionBuilder.toReactionDTO(prosumerOptional.get());
    }

    public Integer insert(ReactionDTO reactionDTO) {
        Reaction reaction = ReactionBuilder.toEntity(reactionDTO);
        reaction = reactionRepository.save(reaction);
        LOGGER.debug("Reaction with idReaction {} was inserted in db", reaction.getIdReaction());
        return reaction.getIdReaction();
    }

    public void update(ReactionDTO reactionDTO) {
        Reaction reaction = ReactionBuilder.toEntity(reactionDTO);
        reaction.setIdReaction(reactionDTO.getIdReaction());
        reactionRepository.save(reaction);
        LOGGER.debug("Reaction with idReaction {} was updated in db", reaction.getIdReaction());
    }

    public void delete(Integer idReaction){
        reactionRepository.deleteById(idReaction);
    }

}
