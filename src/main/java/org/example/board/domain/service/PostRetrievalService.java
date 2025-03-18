package org.example.board.domain.service;

import org.example.board.domain.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRetrievalService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
}