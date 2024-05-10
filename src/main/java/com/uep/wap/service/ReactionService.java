package com.uep.wap.service;

import com.uep.wap.dto.ReactionDTO;
import com.uep.wap.exception.PostNotFoundException;
import com.uep.wap.model.Comment;
import com.uep.wap.model.Like;
import com.uep.wap.model.Post;
import com.uep.wap.model.Reaction;
import com.uep.wap.repository.CommentRepository;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public void addReactiontToPost(ReactionDTO reactionDTO){
        Post post = postRepository.findById(reactionDTO.getPostID())
                .orElseThrow(() -> new PostNotFoundException(reactionDTO.getPostID()));
        Reaction reaction = new Reaction();
        reaction.setLikesList(new HashSet<Like>());
        reactionRepository.save(reaction);

        post.getReactionList().add(reaction);
        postRepository.save(post);
        System.out.println("Reaction added to post!");
    }
    public void addReactionToComment(ReactionDTO reactionDTO){
        Comment comment = commentRepository.findById(reactionDTO.getCommentID())
                .orElseThrow(() -> new PostNotFoundException(reactionDTO.getCommentID()));
        Reaction reaction = new Reaction();
        reaction.setLikesList(new HashSet<Like>());
        reactionRepository.save(reaction);

        comment.getReactionList().add(reaction);
        commentRepository.save(comment);
        System.out.println("Reaction added to comment!");
    }

    public void deleteById(Long reactionID) {reactionRepository.deleteById(reactionID);}
    public Iterable<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }
    public Optional<Reaction> findReactionById(Long id) {
        return reactionRepository.findById(id);
    }
}
