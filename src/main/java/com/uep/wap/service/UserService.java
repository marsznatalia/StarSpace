package com.uep.wap.service;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUserName(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        userRepository.save(user);
        System.out.println("User's name added!");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
