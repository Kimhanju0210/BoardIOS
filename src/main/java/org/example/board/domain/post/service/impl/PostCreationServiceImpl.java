package org.example.board.domain.post.service.impl;

import org.example.board.domain.post.entity.Post;
import org.example.board.domain.post.repository.PostRepository;
import org.example.board.domain.post.service.PostCreationService;
import org.springframework.stereotype.Service;

@Service
public class PostCreationServiceImpl implements PostCreationService {

    private final PostRepository postRepository;

    public PostCreationServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}