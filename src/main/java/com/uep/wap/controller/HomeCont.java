package com.uep.wap.controller;

import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeCont {

    private final UserService userService;

    public HomeCont(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }

    @GetMapping("/home")
    public String homePage(@RequestParam(name = "userId", required = false) Long userId, Model model) {
        Optional<User> user = userService.findUserById(userId);
        if (userId != null) {
            model.addAttribute("selectedUserId", userId);
        } else {
            return "userNotFound";
        }
        return "home";
    }

    @PostMapping("/home")
    public String homePost() {
        return "home";
    }
}
