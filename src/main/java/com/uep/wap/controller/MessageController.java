package com.uep.wap.controller;

import com.uep.wap.dto.MessageDTO;
import com.uep.wap.model.Message;
import com.uep.wap.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //TODO: szukanie wiadomości po słowie kluczowym
//    @GetMapping(path = "/messages/{messageId}")
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

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        try {
            messageService.newMessage(messageDTO);
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message: " + e.getMessage());
        }
    }

}