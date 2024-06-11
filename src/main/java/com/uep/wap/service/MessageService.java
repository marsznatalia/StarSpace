package com.uep.wap.service;

import com.uep.wap.exception.ChatNotFoundException;
import com.uep.wap.exception.MessageNotFoundException;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.dto.MessageDTO;
import com.uep.wap.model.Chat;
import com.uep.wap.model.Message;
import com.uep.wap.model.User;
import com.uep.wap.repository.ChatRepository;
import com.uep.wap.repository.MessageRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    public void newMessage(MessageDTO messageDTO) {
        User user = userRepository.findById(messageDTO.getSenderId())
                .orElseThrow(() -> new UserNotFoundException(messageDTO.getSenderId()));

        Chat chat = chatRepository.findById(messageDTO.getChatId())
                .orElseThrow(() -> new ChatNotFoundException(messageDTO.getChatId()));

        Message message = new Message();
        message.setWhoSent(user);
        message.setInChat(chat);
        message.setContent(messageDTO.getMessageContent());
        messageRepository.save(message);

        chat.getMessagesList().add(message);
        chatRepository.save(chat);

        System.out.println("New message sent!");
    }

    public void editMessage(Long messageId, String editedMessage) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new MessageNotFoundException(messageId));
        message.setContent(editedMessage);
        messageRepository.save(message);
    }

    public Iterable<MessageDTO> getAllMessages() {
        Iterable<Message> messages = messageRepository.findAll();
        return StreamSupport.stream(messages.spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
        messageRepository.deleteById(id);
    }

    public Iterable<MessageDTO> getMessagesByChatId(Long chatId) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatNotFoundException(chatId));
        Iterable<Message> messages = chat.getMessagesList();
        return StreamSupport.stream(messages.spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public void deleteAll() {
        messageRepository.deleteAll();
    }

    private MessageDTO convertToDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setSenderId(message.getWhoSent().getId());
        messageDTO.setMessageContent(message.getContent());
        messageDTO.setChatId(message.getInChat().getId());
        return messageDTO;
    }


}
