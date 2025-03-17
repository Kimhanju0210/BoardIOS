package org.example.board.service.impl;

import org.example.board.entity.Post;
import org.example.board.repository.PostRepository;
import org.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.updateTitle(postDetails.getTitle());
        post.updateContent(postDetails.getContent());
        return postRepository.save(post);
    }

    @Override
    public Post patchPost(Long id, Map<String, Object> updates) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        if (updates.containsKey("title")) {
            post.updateTitle((String) updates.get("title"));
        }
        if (updates.containsKey("content")) {
            post.updateContent((String) updates.get("content"));
        }

        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}