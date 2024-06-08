package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCont {

    private final UserService userService;

    public UserCont(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showAddUserPage(User user) {
        return "add-user";
    }

    @GetMapping("/get-users")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/user")
    public String newUser(@ModelAttribute UserDTO userDTO) {
        System.out.println("Received UserDTO: " + userDTO);
        System.out.println("Username: " + userDTO.getUserName());
        System.out.println("Email: " + userDTO.getEmail());
        System.out.println("Password: " + userDTO.getPassword());
        userService.newUser(userDTO);
        return "users";
    }

}



