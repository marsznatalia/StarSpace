package com.uep.wap.controller;

import com.uep.wap.model.User;
import com.uep.wap.service.NewsletterService;
import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class NewsletterController {
    private final NewsletterService newsletterService;
    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }
}
