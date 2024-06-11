package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserCont {

    private final UserService userService;

    public UserCont(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/")
    public String newUser(@ModelAttribute UserDTO userDTO) {
        System.out.println("Received UserDTO: " + userDTO);
        System.out.println("Username: " + userDTO.getUserName());
        System.out.println("Email: " + userDTO.getEmail());
        System.out.println("Password: " + userDTO.getPassword());
        userService.newUser(userDTO);
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("userId") Long userId,
                        RedirectAttributes redirectAttributes) {
        // Logic to authenticate the user and handle the login process

        // For demonstration purposes, let's assume we have authenticated the user successfully
        // Now we want to redirect to the home page with the selected user's ID as a query parameter
        // Replace "15" with the actual ID of the selected user
        redirectAttributes.addAttribute("userId", userId);

        return "redirect:/index";
    }


}



