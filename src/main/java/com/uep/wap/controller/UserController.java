package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add-user")
    public String addUser(@ModelAttribute UserDTO userDTO) {
        userService.newUser(userDTO);
        return "redirect:/api/add-user";
    }

    @GetMapping("/add-user")
    public String showAddUserForm(User user) {
        return "add-user";
    }

//    @GetMapping(path = "/users")
//    public Iterable<User> getAllUsers() {
//        return userService.getAllUsers();
//    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
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

    @DeleteMapping(path = "/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "User deleted successfully";
    }

    @PatchMapping(path = "users/{id}")
    public String changeUserName(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.changeUserName(userDTO, id);
        return "UserName changed.";
    }

    @PatchMapping(path = "users/make-friend/{id1}/{id2}")
    public String makeFriend(@PathVariable Long id1, @PathVariable Long id2) {
        userService.makeFriend(id1, id2);
        return "Added to friends";
    }

    @PatchMapping(path = "users/delete-friend/{id1}/{id2}")
    public String deleteFriend(@PathVariable Long id1, @PathVariable Long id2) {
        userService.deleteFriend(id1, id2);
        return "Removed from friends";
    }

    @DeleteMapping(path = "/delete-data")
    //USE WITH CAUTION!!!!!!!!!!!!
    public ResponseEntity<String> deleteData() {
        try {
            userService.deleteAllData();
            return ResponseEntity.ok("Data deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting data: " + e.getMessage());
        }
    }

}



