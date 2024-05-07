package com.uep.wap.service;

import com.uep.wap.dto.LikeDTO;
import com.uep.wap.model.Like;
import com.uep.wap.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    //TODO
    public void addLike(LikeDTO likeDTO) {
        Like like = new Like();
        System.out.println("Likes added!");
    }

    public Iterable<Like> getAllLikes() {
        return likeRepository.findAll();
    }

}
