package com.uep.wap.service;

import com.uep.wap.dto.ChatDTO;
import com.uep.wap.model.Chat;
import com.uep.wap.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public void addChat(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setChatName(chatDTO.getChatName());
        chatRepository.save(chat);
        System.out.println("Chats added!");
    }

    public Iterable<Chat> getAllChats() {
        return chatRepository.findAll();
    }

}
