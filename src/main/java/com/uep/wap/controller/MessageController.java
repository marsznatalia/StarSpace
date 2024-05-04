package com.uep.wap.controller;

import com.uep.wap.dto.MessageDTO;
import com.uep.wap.model.Message;
import com.uep.wap.service.MessageService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/messages")
    Iterable<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

//    @GetMapping(path = "/messages/{messageId}") //zmienic to na szukanie po slowie kluczowym
//    public Message findMessageById(@PathVariable Long messageId) {
//        return messageService.findMessageById(messageId)
//                .orElseThrow(() -> new MessageNotFoundException(messageId));
//    }

    @PostMapping(path = "/messages/new-message")
    public String newMessage(@RequestBody MessageDTO messageDTO) {
        messageService.newMessage(messageDTO);
        return "Message created!";
    }

    @PatchMapping(path = "/messages/edit-message/{messageId}")
    public String editMessage(@PathVariable Long messageId, @RequestBody String editedMessage) {
        messageService.editMessage(messageId, editedMessage);
        return "Message edited";
    }

    @DeleteMapping("/messages/{messageId}")
    public String deleteMessage(@PathVariable Long messageId) {
        messageService.deleteById(messageId);
        return "Message deleted!";
    }

    @DeleteMapping("/messages/delete-all")
    public void deleteAll() {
        messageService.deleteAll();
    }

}