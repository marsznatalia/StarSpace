package com.uep.wap.controller;

import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.exception.UserProfileNotFoundException;
import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserProfileController {
    private final UserProfileService userProfileService;


    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(path = "/user-profiles")
    public Iterable<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping(path = "/user-profiles/{id}")
    public UserProfile findUserProfileById(@PathVariable Long id) {
        return userProfileService.findUserProfileById(id)
                .orElseThrow(() -> new UserProfileNotFoundException(id));
    }

    @PostMapping(path = "/user-profile")
    public String newUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        userProfileService.newProfile(userProfileDTO);
        return "User Profile created";
    }

    @DeleteMapping(path = "/user-profiles/{id}")
    public String deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return "UserProfile deleted successfully";
    }

    @PatchMapping(path = "/user-profiles/bio/{id}")
    public String editBio(@PathVariable Long id, @RequestBody String editedBio) {
        userProfileService.editBio(id, editedBio);
        return "Bio edited!";
    }

    @PatchMapping(path = "/user-profiles/pfp/{id}")
    public String changePFP(@PathVariable Long id, @RequestBody byte[] newPfp) {
        userProfileService.changePFP(id, newPfp);
        return "PFP changed!";

    }

    @PatchMapping(path = "/user-profiles/status/{id}/{bool}")
    public String changeStatus(@PathVariable Long id, @PathVariable Boolean bool) {
        userProfileService.changeStatus(id, bool);
        return "Status changed!";
    }
//
//    @PatchMapping(path="/user-profiles/links/{id}")
//    public editLinks(){
//
//    }

}
