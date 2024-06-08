package com.uep.wap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatCont {

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        return "chat";
    }
}
