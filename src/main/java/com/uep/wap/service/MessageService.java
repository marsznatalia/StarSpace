package com.uep.wap.service;

import com.uep.wap.dto.MessageDTO;
import com.uep.wap.model.Message;
import com.uep.wap.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setWhoSent(messageDTO.getWhoSent());
        messageRepository.save(message);
        System.out.println("Messages added!");
    }

    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}
