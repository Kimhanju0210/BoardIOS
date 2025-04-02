package org.example.board.domain.post.service.impl;

import org.example.board.domain.post.repository.PostRepository;
import org.example.board.domain.post.service.PostDeletionService;
import org.springframework.stereotype.Service;

@Service
public class PostDeletionServiceImpl implements PostDeletionService {

    private final PostRepository postRepository;

    public PostDeletionServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}