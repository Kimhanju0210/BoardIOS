package org.example.board.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.post.entity.Post;
import org.example.board.domain.post.repository.PostRepository;
import org.example.board.domain.post.service.PostRetrievalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostRetrievalServiceImpl implements PostRetrievalService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
}