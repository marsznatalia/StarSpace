package com.uep.wap.service;

import com.uep.wap.controller.UserNotFoundException;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void newUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        System.out.println("User added!");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.deleteById(userId);
    }

    public void changeUserName(UserDTO userDTO, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        user.setUserName(userDTO.getUserName());
        userRepository.save(user);
    }

    public void makeFriend(Long id1, Long id2){

        User user1 = userRepository.findById(id1)
                .orElseThrow(() -> new UserNotFoundException(id1));
        User user2 = userRepository.findById(id2)
                .orElseThrow(() -> new UserNotFoundException(id2));

        if (user1.getFriends() == null) {
            user1.setFriends(new HashSet<>());
            System.out.println("Was empty, created new HashSet");
        }

        if (!user1.getFriends().contains(user2)) {
            user1.getFriends().add(user2);
            userRepository.save(user1);
            System.out.println(user2.getUserName() + " added to friends!");
        } else if (!user2.getFriends().contains(user1)) {
            user2.getFriends().add(user1);
            userRepository.save(user2);
            System.out.println(user1.getUserName() + " added to friends!");
        } else {
            System.out.println("Already both friends");
        }
    }


    public void deleteAllData() {
        //USE WITH CAUTION!!!!!!!!!!!!!!!!!!!!!!
        userRepository.deleteAll();
    }
}
