package com.uep.wap.restController;

import com.uep.wap.dto.LikeDTO;
import com.uep.wap.model.Like;
import com.uep.wap.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class LikeController {
    private final LikeService likeService;
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping(path = "/likes/{id}")
    public Optional<Like> findLikeById(@PathVariable Long id) {
        return likeService.findLikeById(id);
    }

    @GetMapping(path = "/likes")
    public Iterable<Like> getAllLikes(){
        return likeService.getAllLikes();
    }

    @PostMapping(path = "/like/add-like")
    public String addReactionToPost(@RequestBody LikeDTO likeDTO){
        likeService.addLike(likeDTO);
        return "Like added!";
    }

    @DeleteMapping("/like/delete-like/{likeID}")
    public String deleteLike(@PathVariable Long likeID) {
        likeService.deleteById(likeID);
        return "Like deleted";
    }
}
