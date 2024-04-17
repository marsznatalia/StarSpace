package com.uep.wap.service;

import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public void addBio(UserProfileDTO userProfileDTO) {
        UserProfile userProfile= new UserProfile();
        userProfile.setBio(userProfileDTO.getBio());
        userProfileRepository.save(userProfile);
        System.out.println("Bio added!");
    }

    public Iterable<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

}
