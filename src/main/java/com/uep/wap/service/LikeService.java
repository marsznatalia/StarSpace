package com.uep.wap.service;

import com.uep.wap.dto.LikeDTO;
import com.uep.wap.exception.ReactionNotFoundException;
import com.uep.wap.model.Like;
import com.uep.wap.model.Reaction;
import com.uep.wap.repository.LikeRepository;
import com.uep.wap.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ReactionRepository reactionRepository;

    public void addLike(LikeDTO likeDTO) {
        Reaction reaction = reactionRepository.findById(likeDTO.getReactionID())
                .orElseThrow(() -> new ReactionNotFoundException(likeDTO.getReactionID()));
        Like like = new Like();
        like.setReaction(reaction);
        likeRepository.save(like);

        reaction.getLikesList().add(like);
        reactionRepository.save(reaction);
        System.out.println("Like added!");
    }
    public void deleteById(Long likeID) {likeRepository.deleteById(likeID);}
    public Iterable<Like> getAllLikes() {
        return likeRepository.findAll();
    }
    public Optional<Like> findLikeById(Long id) {
        return likeRepository.findById(id);
    }

}
