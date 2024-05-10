package com.uep.wap.controller;

import com.uep.wap.dto.NewsletterDTO;
import com.uep.wap.exception.NewsletterNotFoundException;
import com.uep.wap.model.Newsletter;
import com.uep.wap.service.NewsletterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class NewsletterController {
    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @GetMapping(path = "/newsletters")
    public Iterable<Newsletter> getAllNewsletters() {
        return newsletterService.getAllNewsletters();
    }

    @GetMapping(path = "/newsletter/{newsletterID}")
    public Newsletter findNewsletterById(@PathVariable Long newsletterID) {
        return newsletterService.findPostById(newsletterID)
                .orElseThrow(() -> new NewsletterNotFoundException(newsletterID));
    }

    @PostMapping(path = "/newsletter/add-theme")
    public String addNewsletter(@RequestBody NewsletterDTO newsletterDTO) {
        newsletterService.addNewsletter(newsletterDTO);
        return "Newsletter created!";
    }

    @DeleteMapping(path = "/newsletter/delete-newsletter/{newsletterID}")
    public String deleteNewsletter(@PathVariable Long newsletterID) {
        newsletterService.deleteById(newsletterID);
        return "Newsletter deleted!";
    }
}
