package com.uep.wap.controller;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.model.Chat;
import com.uep.wap.service.ChatService;
import com.uep.wap.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ChatCont {

    private final ChatService chatService;
    private final UserService userService;

    public ChatCont(ChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }


//    @GetMapping("/chat")
//    public String getChats(Model model) {
//        Iterable<ChatDTO> chats = chatService.getAllChats();
//        model.addAttribute("chat", chats);
//        return "chat";
//    }
}
