package com.uep.wap.controller;

import com.uep.wap.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileCont {

    @GetMapping("/userProfile")
    public String showUserProfile(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "userProfile";
    }


}
