package com.uep.wap.service;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.exception.CommentNotFoundException;
import com.uep.wap.exception.PostNotFoundException;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.Comment;
import com.uep.wap.model.Post;
import com.uep.wap.model.Reaction;
import com.uep.wap.model.User;
import com.uep.wap.repository.CommentRepository;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public void addCommentToPost(CommentDTO commentDTO) {
        Post post = postRepository.findById(commentDTO.getPostID())
                .orElseThrow(() -> new PostNotFoundException(commentDTO.getPostID()));
        Comment comment = new Comment();

        User user = userRepository.findById(commentDTO.getAuthorID())
                .orElseThrow(() -> new UserNotFoundException(commentDTO.getAuthorID()));

        comment.setAuthor(user);
        comment.setPost(post);
        comment.setContent(commentDTO.getContent());
        comment.setDatePosted(new Date());
        comment.setChildren(new HashSet<Comment>());
        comment.setReactionList(new HashSet<Reaction>());
        commentRepository.save(comment);

        post.getCommentList().add(comment);
        postRepository.save(post);
        System.out.println("Comment added to post!");
    }

    public void addCommentToComment(CommentDTO commentDTO) {
        Comment parent = commentRepository.findById(commentDTO.getCommentID())
                .orElseThrow(() -> new CommentNotFoundException(commentDTO.getCommentID()));
        Comment comment = new Comment();

        User user = userRepository.findById(commentDTO.getAuthorID())
                .orElseThrow(() -> new UserNotFoundException(commentDTO.getAuthorID()));

        comment.setAuthor(user);

        comment.setParent(parent);
        comment.setContent(commentDTO.getContent());
        comment.setDatePosted(new Date());
        comment.setReactionList(new HashSet<Reaction>());
        commentRepository.save(comment);

        parent.getChildren().add(comment);
        commentRepository.save(parent);
        System.out.println("Comment added to comment!");
    }

    public void deleteById(Long commentID) {
        commentRepository.deleteById(commentID);
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }

}
