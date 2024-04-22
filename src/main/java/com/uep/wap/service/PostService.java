package com.uep.wap.service;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.dto.StudentDTO;
import com.uep.wap.model.Post;
import com.uep.wap.model.Student;
import com.uep.wap.repository.PostRepository;
import com.uep.wap.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void addContent(PostDTO postDTO) {
        Post post = new Post();
        post.setContent(postDTO.getContent());
        postRepository.save(post);
        System.out.println("Content added!");
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

}
