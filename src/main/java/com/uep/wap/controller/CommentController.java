package com.uep.wap.controller;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/comments/{id}")
    public Optional<Comment> findCommentById(@PathVariable Long id) {
        return commentService.findCommentById(id);
    }

    @GetMapping(path = "/comments")
    public Iterable<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping(path = "/comment/add-comment-to-post")
    public String addCommentToPost(@RequestBody CommentDTO commentDTO) {
        commentService.addCommentToPost(commentDTO);
        return "Comment added!";
    }

    @PostMapping(path = "/comment/add-comment-to-comment")
    public String addCommentToComment(@RequestBody CommentDTO commentDTO) {
        commentService.addCommentToComment(commentDTO);
        return "Comment added!";
    }

    @DeleteMapping("/comment/delete-comment/{commentID}")
    public String deleteComment(@PathVariable Long commentID) {
        commentService.deleteById(commentID);
        return "Comment deleted";
    }
}
