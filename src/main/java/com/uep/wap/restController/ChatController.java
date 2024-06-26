package com.uep.wap.restController;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.exception.ChatNotFoundException;
import com.uep.wap.model.Chat;
import com.uep.wap.service.ChatService;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(path = "/api")
public class ChatController {

    private final ChatService chatService;
    private final UserService userService;

    public ChatController(ChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @GetMapping("/chat/{userId}")
    public ResponseEntity<String> getChatsById(@PathVariable("userId") Long userId, Model model) {
        try {
            Set<Chat> chats = userService.getUserChats(userId);
            model.addAttribute("chat", chats);
            model.addAttribute("userId", userId);
            return ResponseEntity.ok("Chats retrieved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving chats: " + e.getMessage());
        }
    }

    @GetMapping(path = "/chats")
    public Iterable<Chat> getAllChats() {
        Iterable<Chat> chats = chatService.getAllChats();
        return ResponseEntity.ok(chats).getBody();
    }

    @GetMapping(path = "/chats/{chatId}")
    public Chat findChatById(@PathVariable Long chatId) {
        return chatService.findChatById(chatId)
                .orElseThrow(() -> new ChatNotFoundException(chatId));
    }

    @PostMapping(path = "/chats/new-chat")
    public String newChat(@RequestBody ChatDTO chatDTO) {
        chatService.newChat(chatDTO);
        return "Chat created!";
    }

    @PatchMapping(path = "chats/add-user/{chatId}")
    public String addUserToChat(@PathVariable Long chatId, @RequestBody ChatDTO chatDTO) {
        chatService.addUserToChat(chatId, chatDTO);
        return "Added users to chat!";
    }

    @PatchMapping(path = "chats/remove-user/{chatId}")
    public String removeUserFromChat(@PathVariable Long chatId, @RequestBody ChatDTO chatDTO) {
        chatService.removeUserFromChat(chatId, chatDTO);
        return "Removed user from chat!";
    }

    @PatchMapping(path = "chats/change-name/{chatId}")
    public String changeChatName(@PathVariable Long chatId, @RequestBody String newChatName) {
        chatService.changeChatName(chatId, newChatName);
        return "Chat name changed!";
    }

    @DeleteMapping("/chats/delete/{id}")
    public String deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
        return "Chat deleted!";
    }

}

