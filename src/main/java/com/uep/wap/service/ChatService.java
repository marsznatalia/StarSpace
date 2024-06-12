package com.uep.wap.service;

import com.uep.wap.exception.ChatNotFoundException;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.dto.ChatDTO;
import com.uep.wap.model.Chat;
import com.uep.wap.model.User;
import com.uep.wap.repository.ChatRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    public void newChat(ChatDTO chatDTO) {

        if (chatDTO.getUsersInChatIds() == null) {
            throw new IllegalArgumentException("Users in chat IDs cannot be null");
        }

        Set<User> usersInChat = new HashSet<>();

        for (Long userId : chatDTO.getUsersInChatIds()) {
            User userInChat = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException(userId));
            usersInChat.add(userInChat);

        }

        Chat chat = new Chat();
        chat.setChatName(chatDTO.getChatName());
        chat.setChatType(chatDTO.getChatType()); //TODO check czy chat type jest w sumie potrzebny?
        chat.setChatUsersList(new HashSet<>());

        for (User user : usersInChat) {
            if (user.getChatList() == null) {
                user.setChatList(new HashSet<>());
                System.out.println("User " + user.getUserName() + " didn't have any conversations yet, created new HashSet");
            }
            chat.getChatUsersList().add(user);
        }

        chatRepository.save(chat);

        for (User user : chat.getChatUsersList()) {
            if (user.getChatList() == null) {
                user.setChatList(new HashSet<>());
            }
            user.getChatList().add(chat);
            userRepository.save(user);
            System.out.println("Powinno dodac chat userowi " + user.getUserName() + user.getChatList());
        }
        System.out.println("Chat created!");
    }

    public void addUserToChat(Long chatId, ChatDTO chatDTO) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatNotFoundException(chatId));

        for (Long userId : chatDTO.getHelpListIds()) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException(userId));
            chat.getChatUsersList().add(user);
        }

        chatRepository.save(chat);

        for (User user : chat.getChatUsersList()) {
            if (!user.getChatList().contains(chat)) {
                user.getChatList().add(chat);
                userRepository.save(user);
            }
        }
    }

    public void removeUserFromChat(Long chatId, ChatDTO chatDTO) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatNotFoundException(chatId));

        for (Long userId : chatDTO.getHelpListIds()) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException(userId));
            if (chat.getChatUsersList().contains(user)) {
                chat.getChatUsersList().remove(user);
                user.getChatList().remove(chat);
                userRepository.save(user);
            }
        }
        chatRepository.save(chat);
    }

    public void changeChatName(Long chatId, String newChatName) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatNotFoundException(chatId));

        chat.setChatName(newChatName);
        chatRepository.save(chat);
    }

    public Iterable<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> findChatById(Long chatId) {
        return chatRepository.findById(chatId);
    }

    public void deleteById(Long id) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> new ChatNotFoundException(id));
        chatRepository.deleteById(id);
    }

    private ChatDTO convertToDTO(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setId(chat.getId());
        chatDTO.setChatName(chat.getChatName());
        chatDTO.setChatType(chat.getChatType());
        chatDTO.setUsersInChatIds(chat.getChatUsersList().stream().map(User::getId).collect(Collectors.toList()));
        chatDTO.setUsersInChat(new ArrayList<>(chat.getChatUsersList()));
        return chatDTO;
    }

    public List<ChatDTO> findChatsByUserId(Long userId) {
        Iterable<Chat> chats = chatRepository.findAll();
        ArrayList<Chat> chatList = null;

        for (Chat chat : chats) {
            if (chat.getChatUsersList().contains(userId)) {
                chatList.add(chat);
            }
        }
        return StreamSupport.stream(chats.spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
