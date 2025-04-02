package org.example.board.domain.post.service;

import org.example.board.domain.post.entity.Post;

import java.util.Map;

public interface PostUpdateService {
    Post updatePost(Long id, Post postDetails);
    Post patchPost(Long id, Map<String, Object> updates);
}