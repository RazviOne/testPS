package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ReactionDTO;
import ro.tuc.ds2020.services.ReactionService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    @Autowired
    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @GetMapping()
    public ResponseEntity<List<ReactionDTO>> getReactions() {
        List<ReactionDTO> dtos = reactionService.findReactions();
        for (ReactionDTO dto : dtos) {
            Link reactionLink = linkTo(methodOn(ReactionController.class)
                    .getReactionById(dto.getIdReaction())).withRel("reactionDetails");
            dto.add(reactionLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertReaction(@Valid @RequestBody ReactionDTO reactionDTO) {
        Integer idReaction = reactionService.insert(reactionDTO);
        return new ResponseEntity<>(idReaction, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReactionDTO> getReactionById(@PathVariable("id") Integer idReaction) {
        ReactionDTO failedDto = new ReactionDTO();
        failedDto.setIdReaction(-1);
        try {
            ReactionDTO dto = reactionService.findReactionById(idReaction);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<ReactionDTO> updateReaction(@Valid @RequestBody ReactionDTO reactionDTO,
                                                      @PathVariable("id") Integer idReaction){
        ReactionDTO failedDto = new ReactionDTO();
        failedDto.setIdReaction(-1);
        try {
            reactionService.findReactionById(idReaction);
            reactionDTO.setIdReaction(idReaction);
            reactionService.update(reactionDTO);
            return new ResponseEntity<>(reactionDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReactionDTO> deleteReaction(@PathVariable("id") Integer idReaction) {
        ReactionDTO failedDto = new ReactionDTO();
        failedDto.setIdReaction(-1);
        try {
            ReactionDTO dto = reactionService.findReactionById(idReaction);
            reactionService.delete(idReaction);
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<String> deleteReactionsFromPost(@PathVariable("id") Integer idPost) {
        List<ReactionDTO> reactionDTOList = reactionService.findReactions();
        for (ReactionDTO reactionDTO : reactionDTOList) {
            if(reactionDTO.getIdPost().equals(idPost)){
                reactionService.delete(reactionDTO.getIdReaction());
            }
        }

        return new ResponseEntity<>("Deleted all reactions from post with idPost : " + idPost, HttpStatus.OK);
    }

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<String> deleteReactionsFromPerson(@PathVariable("id") Integer idPerson) {
        List<ReactionDTO> reactionDTOList = reactionService.findReactions();
        for (ReactionDTO reactionDTO : reactionDTOList) {
            if(reactionDTO.getIdPerson().equals(idPerson)){
                reactionService.delete(reactionDTO.getIdReaction());
            }
        }

        return new ResponseEntity<>("Deleted all reactions from person with idPerson : " + idPerson, HttpStatus.OK);
    }

}
