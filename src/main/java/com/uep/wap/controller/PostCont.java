package com.uep.wap.controller;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.service.PostService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostCont {

    private final PostService postService;

    public PostCont(PostService postService) {
        this.postService = postService;
    }

//    @PostMapping("/add-post")
//    public String addPost(@ModelAttribute PostDTO postDTO, Model model) {
//        postService.addPost(postDTO);
//        model.addAttribute("post", postDTO);
//        return "home";
//    }


    @PostMapping("/add-post")
    public String addPost(@RequestParam("userId") Long userId, @ModelAttribute PostDTO postDTO, Model model) {
        postService.addPost(postDTO);
        model.addAttribute("post", postDTO);
        return "redirect:/posts";
    }



    @GetMapping("/posts")
    public String getPosts(Model model) {
        Iterable<PostDTO> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "home";
    }
}



