package com.uep.wap.service;

import com.uep.wap.dto.NewsletterDTO;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.*;
import com.uep.wap.repository.NewsletterRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;
    @Autowired
    private UserRepository userRepository;

    public void addNewsletter(NewsletterDTO newsletterDTO) {
        User user = userRepository.findById(newsletterDTO.getUserID())
                .orElseThrow(() -> new UserNotFoundException(newsletterDTO.getUserID()));
        Newsletter newsletter = new Newsletter();
        newsletter.setUser(user);
        newsletter.setTitle(newsletterDTO.getTitle());
        newsletter.setNewsList(new HashSet<News>());
        newsletterRepository.save(newsletter);
        System.out.println("Newsletter added!");
    }

    public void deleteById(Long newsletterID){
        newsletterRepository.deleteById(newsletterID);
    }

    public Iterable<Newsletter> getAllNewsletters() {
        return newsletterRepository.findAll();
    }
    public Optional<Newsletter> findPostById(Long id) {
        return newsletterRepository.findById(id);
    }
}
