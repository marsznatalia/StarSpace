package com.uep.wap.service;

import com.uep.wap.dto.NewsDTO;
import com.uep.wap.exception.NewsNotFoundException;
import com.uep.wap.exception.NewsletterNotFoundException;
import com.uep.wap.model.Comment;
import com.uep.wap.model.News;
import com.uep.wap.model.Newsletter;
import com.uep.wap.repository.NewsRepository;
import com.uep.wap.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsletterRepository newsletterRepository;

    public void addNews(NewsDTO newsDTO) {
        Newsletter newsletter = newsletterRepository.findById(newsDTO.getNewsletterID())
                .orElseThrow(() -> new NewsletterNotFoundException(newsDTO.getNewsletterID()));
        News news = new News();
        news.setNewsletter(newsletter);
        news.setTitle(newsDTO.getTitle());
        news.setContent(newsDTO.getContent());
        news.setDatePosted(new Date());
        newsRepository.save(news);

        newsletter.getNewsList().add(news);
        newsletterRepository.save(newsletter);
        System.out.println("News added!");
    }

    public void editNews(Long newsID, NewsDTO newsDTO){
        News news = newsRepository.findById(newsID)
                .orElseThrow(() -> new NewsNotFoundException(newsID));
        news.setTitle(newsDTO.getTitle());
        news.setContent(newsDTO.getContent());
        newsRepository.save(news);
        System.out.println("News edited!");
    }

    public void deleteById(Long newsID) {
        newsRepository.deleteById(newsID);
    }

    public Iterable<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> findNewsById(Long id) {
        return newsRepository.findById(id);
    }
}
