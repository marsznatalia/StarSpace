package com.uep.wap.controller;

import com.uep.wap.dto.ReactionDTO;
import com.uep.wap.model.Reaction;
import com.uep.wap.service.ReactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ReactionController {
    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }
    @GetMapping(path = "/reactions/{id}")
    public Optional<Reaction> findReactionById(@PathVariable Long id) {
        return reactionService.findReactionById(id);
    }

    @GetMapping(path = "/reactions")
    public Iterable<Reaction> getAllReactions(){
        return reactionService.getAllReactions();
    }

    @PostMapping(path = "/reaction/add-reaction-to-post")
    public String addReactionToPost(@RequestBody ReactionDTO reactionDTO){
        reactionService.addReactiontToPost(reactionDTO);
        return "Reaction added!";
    }
    @PostMapping(path = "/reaction/add-reaction-to-comment")
    public String addReactionToComment(@RequestBody ReactionDTO reactionDTO){
        reactionService.addReactionToComment(reactionDTO);
        return "Reaction added!";
    }

    @DeleteMapping("/reaction/delete-reaction/{reactionID}")
    public String deleteReaction(@PathVariable Long reactionID) {
        reactionService.deleteById(reactionID);
        return "Comment deleted";
    }
}
