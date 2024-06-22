package com.uep.wap.restController;

import com.uep.wap.dto.NewsDTO;
import com.uep.wap.model.News;
import com.uep.wap.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(path = "/news/{id}")
    public Optional<News> findNewsById(@PathVariable Long id) {
        return newsService.findNewsById(id);
    }

    @GetMapping(path = "/news")
    public Iterable<News> getAllNews(){
        return newsService.getAllNews();
    }
    @PostMapping(path = "/news/add-news")
    public String addNews(@RequestBody NewsDTO newsDTO){
        newsService.addNews(newsDTO);
        return "News added!";
    }
    @PatchMapping("/news/edit-news/{newsID}")
    public String editPost(@PathVariable Long newsID, @RequestBody NewsDTO newsDTO) {
        newsService.editNews(newsID, newsDTO);
        return "News edited";
    }
    @DeleteMapping("/news/delete-news/{newsID}")
    public String deleteComment(@PathVariable Long newsID) {
        newsService.deleteById(newsID);
        return "News deleted";
    }
}
