package com.uep.wap.service;

import com.uep.wap.dto.ReactionDTO;
import com.uep.wap.model.Reaction;
import com.uep.wap.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;
    public Iterable<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

}
