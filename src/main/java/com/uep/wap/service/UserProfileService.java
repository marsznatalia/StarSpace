package com.uep.wap.service;

import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.User;
import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    public void newProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(userRepository.findById(userProfileDTO.getId())
                .orElseThrow(() -> new UserNotFoundException(userProfileDTO.getId()))
        );
        userProfile.setBio(userProfileDTO.getBio());
        userProfile.setStatus(userProfileDTO.getStatus());
        userProfile.setLinks(userProfileDTO.getLinks());
        userProfileRepository.save(userProfile);
        System.out.println("New profile created!");
    }

    public Optional<UserProfile> findUserProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    public Iterable<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }

    public void editBio(Long id, String editedBio) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.getUserProfile().setBio(editedBio);
        userRepository.save(user);
    }

    public void changePFP(Long id, byte[] newPfp) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.getUserProfile().setProfilePicture(newPfp);
        userRepository.save(user);
    }

    public void changeStatus(Long id, Boolean bool) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.getUserProfile().setStatus(bool);
        userRepository.save(user);
    }

}
