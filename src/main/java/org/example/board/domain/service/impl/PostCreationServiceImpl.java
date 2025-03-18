package org.example.board.domain.service.impl;

import org.example.board.domain.entity.Post;
import org.example.board.domain.repository.PostRepository;
import org.example.board.domain.service.PostCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCreationServiceImpl implements PostCreationService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}