package com.uep.wap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeCont {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String homePost() {
        return "home";
    }
}
