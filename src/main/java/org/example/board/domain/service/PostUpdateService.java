package org.example.board.domain.service;

import org.example.board.domain.entity.Post;

import java.util.Map;

public interface PostUpdateService {
    Post updatePost(Long id, Post postDetails);
    Post patchPost(Long id, Map<String, Object> updates);
}