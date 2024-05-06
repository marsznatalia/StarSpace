package com.uep.wap.controller;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.dto.ReactionDTO;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Reaction;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    //dodawac i usuwac posty
    //pobierac charty
    //pobierac chaty, usuwac chat
    //tworzyc userProfile (z zastrzerzeniem jeden na usera)
    //co z newsletter?


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping(path = "/user")
    public String newUser(@RequestBody UserDTO userDTO) {
        userService.newUser(userDTO);
        return "User added!";
    }

//    @PostMapping(path = "/user/{userID}/newsletter/{newsletterID}")
//    public String addNewsletterToUser(@PathVariable Long userID, @PathVariable Long newsletterID) {
//        userService.addNewsletterByID(userID, newsletterID);
//        return "Newsletter added";
//    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "User deleted successfully";
    }

    @PatchMapping("users/{id}")
    public String changeUserName(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.changeUserName(userDTO, id);
        return "UserName changed.";
    }

    @PatchMapping("users/make-friend/{id1}/{id2}")
    public String makeFriend(@PathVariable Long id1, @PathVariable Long id2) {
        userService.makeFriend(id1, id2);
        return "Added to friends";
    }

    @PatchMapping("users/delete-friend/{id1}/{id2}")
    public String deleteFriend(@PathVariable Long id1, @PathVariable Long id2) {
        userService.deleteFriend(id1, id2);
        return "Removed from friends";
    }

    @DeleteMapping("/delete-data")
    //USE WITH CAUTION!!!!!!!!!!!!
    public ResponseEntity<String> deleteData() {
        try {
            // Call a method from your UserService to delete data
            userService.deleteAllData(); // You need to implement this method
            return ResponseEntity.ok("Data deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting data: " + e.getMessage());
        }
    }

    @PostMapping("user/{userID}/addPost")
    public String addPost(@PathVariable Long userID,@RequestBody PostDTO postDTO) {
        userService.addPost(userID, postDTO);
        return "Post added";
    }
    @PatchMapping("user/{userID}/deletePost")
    public String deletePost(@PathVariable Long userID,@PathVariable Long postID) {
        userService.deletePost(userID, postID);
        return "Post deleted";
    }

    @PatchMapping("user/{userID}/editPost/{postID}")
    public String editPost(@PathVariable Long userID,@PathVariable Long postID,@RequestBody String editedComment) {
        userService.editPost(userID, postID, editedComment);
        return "Post edited";
    }

    @PatchMapping("user/{userID}/post/{postID}/addReaction")
    public String addReaction(@PathVariable Long userID, @PathVariable Long postID, @RequestBody ReactionDTO reactionDTO) {
        userService.addReaction(userID, postID, reactionDTO);
        return "Reaction added";
    }
    @PatchMapping("user/{userID}/post/{postID}/deleteReaction/{reactionID}")
    public String deleteReaction(@PathVariable Long userID, @PathVariable Long postID, @PathVariable Long reactionID) {
        userService.deleteReaction(userID, postID, reactionID);
        return "Reaction deleted";
    }

    @PatchMapping("user/{userID}/post/{postID}/addComment")
    public String addComment(@PathVariable Long userID, @PathVariable Long postID, @RequestBody CommentDTO commentDTO) {
        userService.addComment(userID, postID, commentDTO);
        return "Comment added";
    }
    @PatchMapping("user/{userID}/post/{postID}/comment/addComment/{commentID}")
    public String addComment(@PathVariable Long userID, @PathVariable Long postID, @PathVariable Long commentID, @RequestBody CommentDTO commentDTO) {
        userService.addComment(userID, postID, commentID, commentDTO);
        return "Comment added";
    }
    @PatchMapping("user/{userID}/post/{postID}/comment/deleteComment/{commentID}")
    public String deleteComment(@PathVariable Long userID, @PathVariable Long postID, @PathVariable Long commentID) {
        userService.deleteComment(userID, postID, commentID);
        return "Comment deleted";
    }
}



