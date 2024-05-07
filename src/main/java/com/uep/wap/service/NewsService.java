package com.uep.wap.service;

import com.uep.wap.dto.NewsDTO;
import com.uep.wap.model.News;
import com.uep.wap.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void addNews(NewsDTO newsDTO) {
        News news = new News();
        news.setTitle(newsDTO.getTitle());
        newsRepository.save(news);
        System.out.println("News added!");
    }

    public Iterable<News> getAllNews() {
        return newsRepository.findAll();
    }
}
