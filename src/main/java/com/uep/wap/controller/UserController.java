package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api")
public class UserController {

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

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteById(id);
        return "User deleted successfully";
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

}



