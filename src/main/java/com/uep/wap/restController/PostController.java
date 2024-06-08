package com.uep.wap.restController;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping(path = "/posts")
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(path = "/posts/{id}")
    public Optional<Post> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/post/add-post")
    public String addPost(@RequestBody PostDTO postDTO) {
        postService.addPost(postDTO);
        return "Post added";
    }

    @PatchMapping("/post/edit-post/{postID}")
    public String editPost(@PathVariable Long postID, @RequestBody String editedContent) {
        postService.editPost(postID, editedContent);
        return "Post edited";
    }

    @DeleteMapping("/post/delete-post/{postID}")
    public String deletePost(@PathVariable Long postID) {
        postService.deleteById(postID);
        return "Post deleted";
    }

}
