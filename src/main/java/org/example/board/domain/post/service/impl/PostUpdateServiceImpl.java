package org.example.board.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.post.entity.Post;
import org.example.board.domain.post.repository.PostRepository;
import org.example.board.domain.post.service.PostUpdateService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostUpdateServiceImpl implements PostUpdateService {

    private final PostRepository postRepository;

    @Override
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.updateTitle(postDetails.getTitle());
        post.updateContent(postDetails.getContent());
        return postRepository.save(post);
    }

    @Override
    public Post patchPost(Long id, Map<String, Object> updates) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (updates.containsKey("title")) {
            post.updateTitle((String) updates.get("title"));
        }
        if (updates.containsKey("content")) {
            post.updateContent((String) updates.get("content"));
        }

        return postRepository.save(post);
    }
}