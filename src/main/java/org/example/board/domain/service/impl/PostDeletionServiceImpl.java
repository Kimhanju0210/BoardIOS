package org.example.board.domain.service.impl;

import org.example.board.domain.repository.PostRepository;
import org.example.board.domain.service.PostDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDeletionServiceImpl implements PostDeletionService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}