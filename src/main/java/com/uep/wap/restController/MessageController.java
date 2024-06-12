package com.uep.wap.restController;

import com.uep.wap.dto.MessageDTO;
import com.uep.wap.model.Message;
import com.uep.wap.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(path = "/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/messages")
    Iterable<MessageDTO> getAllMessages() {
        return messageService.getAllMessages();
    }

//    @GetMapping("/messages/{chatId}")
//    public Iterable<MessageDTO> getMessagesByChatId(@PathVariable Long chatId){
//        return messageService.getMessagesByChatId(chatId);
//    }


    @GetMapping(path = "/messages/{chatId}", produces = "application/json")
    public ArrayList<MessageDTO> getMessagesByChatId(@PathVariable Long chatId) {
        Iterable<MessageDTO> messages = messageService.getMessagesByChatId(chatId);
        ArrayList<MessageDTO> messageDTOs = new ArrayList<>();
        messages.forEach(message -> {
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setId(message.getId());
            messageDTO.setMessageContent(message.getMessageContent());
            messageDTO.setSenderId(message.getSenderId());
            messageDTOs.add(messageDTO);
        });
        return ResponseEntity.ok(messageDTOs).getBody();
    }


//    @PostMapping(path = "/messages/new-message")
//    public String newMessage(@RequestBody MessageDTO messageDTO) {
//        messageService.newMessage(messageDTO);
//        return "Message created!";
//    }


    @PostMapping(path = "/messages/new-message", produces = "application/json")
    public ResponseEntity<MessageDTO> newMessage(@RequestBody MessageDTO messageDTO) {

        messageService.newMessage(messageDTO);
        return ResponseEntity.ok(messageDTO);
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