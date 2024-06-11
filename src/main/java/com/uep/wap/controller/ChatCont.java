package com.uep.wap.controller;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatCont {

    private final ChatService chatService;

    public ChatCont(ChatService chatService) {
        this.chatService = chatService;
    }



    @GetMapping("/chat")
    public String getChats(@RequestParam("userId") Long userId, Model model) {
        Iterable<ChatDTO> chats = chatService.findChatsByUserId(userId);
        model.addAttribute("chat", chats);
        model.addAttribute("userId", userId);
        return "chat";
    }

//    @GetMapping("/chat")
//    public String getChats(Model model) {
//        Iterable<ChatDTO> chats = chatService.getAllChats();
//        model.addAttribute("chat", chats);
//        return "chat";
//    }
}
