package org.example.board.domain.service.impl;

import org.example.board.domain.entity.Post;
import org.example.board.domain.repository.PostRepository;
import org.example.board.domain.service.PostRetrievalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostRetrievalServiceImpl implements PostRetrievalService {

    private final PostRepository postRepository;

    public PostRetrievalServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
}