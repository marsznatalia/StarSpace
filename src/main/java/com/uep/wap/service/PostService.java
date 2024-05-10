package com.uep.wap.service;

import com.uep.wap.exception.PostNotFoundException;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.Comment;
import com.uep.wap.model.Post;
import com.uep.wap.model.Reaction;
import com.uep.wap.model.User;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void addPost(PostDTO postDTO) {
        User user = userRepository.findById(postDTO.getUserAuthorId())
                .orElseThrow(() -> new UserNotFoundException(postDTO.getUserAuthorId()));

        Post post = new Post();
        post.setUser(user);
        post.setContent(postDTO.getContent());
        post.setDatePosted(new Date());
        post.setCommentList(new HashSet<Comment>());
        post.setReactionList(new HashSet<Reaction>());
        postRepository.save(post);

        user.getPostsList().add(post);
        userRepository.save(user);
        System.out.println("Post added!");
    }


    public void editPost(Long postId, String editedContent) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        post.setContent(editedContent);
        postRepository.save(post);
    }

    public void deleteById(Long postID) {
        postRepository.deleteById(postID);
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }
}
