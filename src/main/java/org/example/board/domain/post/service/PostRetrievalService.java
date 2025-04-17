package org.example.board.domain.post.service;

import org.example.board.domain.post.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRetrievalService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
}