package com.uep.wap.controller;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.model.Chat;
import com.uep.wap.service.ChatService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping(path = "/chats")
    Iterable<Chat> getAllChats() {
        return chatService.getAllChats();
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

    @DeleteMapping("/chats/{id}")
    public String deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
        return "Chat deleted!";
    }

}

