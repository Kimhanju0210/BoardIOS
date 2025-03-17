package org.example.board.service;

import org.example.board.entity.Post;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    Post createPost(Post post);
    Post updatePost(Long id, Post postDetails);
    Post patchPost(Long id, Map<String, Object> updates);
    void deletePost(Long id);
}