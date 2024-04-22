package com.uep.wap.service;

import com.uep.wap.dto.NewsletterDTO;
import com.uep.wap.model.Newsletter;
import com.uep.wap.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    public void addNewsletter(NewsletterDTO newsletterDTO) {
        Newsletter newsletter = new Newsletter();
        newsletter.setTitle(newsletterDTO.getTitle());
        newsletterRepository.save(newsletter);
        System.out.println("Newsletters added!");
    }

    public Iterable<Newsletter> getAllNewsletters() {
        return newsletterRepository.findAll();
    }

}
