package com.uep.wap.controller;

import com.uep.wap.service.ChatService;
import com.uep.wap.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class ChatCont {

    private final ChatService chatService;
    private final UserService userService;

    public ChatCont(ChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }
}
