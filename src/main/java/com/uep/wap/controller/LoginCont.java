package com.uep.wap.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCont {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}