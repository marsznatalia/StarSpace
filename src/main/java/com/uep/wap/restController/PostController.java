package com.uep.wap.restController;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Iterable<PostDTO> getAllPosts() {
        Iterable<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts).getBody();
    }

    @GetMapping(path = "/posts/{id}")
    public Optional<Post> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/post/add-post")
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDTO) {
        try {
            postService.addPost(postDTO);
            return ResponseEntity.ok("Post added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding post: " + e.getMessage());
        }
    }

//    @PatchMapping("/post/edit-post/{postID}")
//    public String editPost(@PathVariable Long postID, @RequestBody String editedContent) {
//        postService.editPost(postID, editedContent);
//        return "Post edited";
//    }


    @PatchMapping("/post/edit-post/{postID}")
    public ResponseEntity<String> editPost(@PathVariable Long postID, @RequestBody PostDTO postDTO) {
        try {
            postService.editPost(postID, postDTO.getContent());
            return ResponseEntity.ok("Post edited successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing post: " + e.getMessage());
        }
    }




    @DeleteMapping("/post/delete-post/{postID}")
    public ResponseEntity<String> deletePost(@PathVariable Long postID) {
        try {
            postService.deleteById(postID);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting post: " + e.getMessage());
        }
    }

}
