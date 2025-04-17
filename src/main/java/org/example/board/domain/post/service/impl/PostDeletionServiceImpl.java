package org.example.board.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.post.repository.PostRepository;
import org.example.board.domain.post.service.PostDeletionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeletionServiceImpl implements PostDeletionService {

    private final PostRepository postRepository;

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}