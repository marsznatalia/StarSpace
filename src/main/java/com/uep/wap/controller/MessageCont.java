package com.uep.wap.controller;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.dto.MessageDTO;
import com.uep.wap.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageCont {

    private final MessageService messageService;

    public MessageCont(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public String getMessages(Model model){
        Iterable<MessageDTO> messages = messageService.getAllMessages();
        model.addAttribute("message", messages);
        return "chat";
    }

//
//    @PostMapping
////    @ResponseBody
//    public void newMessage(@RequestBody MessageDTO messageDTO){
//        messageService.newMessage(messageDTO);
//    }



}
