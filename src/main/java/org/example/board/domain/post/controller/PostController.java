package org.example.board.domain.post.controller;

import org.example.board.domain.post.entity.Post;
import org.example.board.domain.post.service.PostCreationService;
import org.example.board.domain.post.service.PostDeletionService;
import org.example.board.domain.post.service.PostRetrievalService;
import org.example.board.domain.post.service.PostUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRetrievalService postRetrievalService;
    private final PostCreationService postCreationService;
    private final PostUpdateService postUpdateService;
    private final PostDeletionService postDeletionService;

    public PostController(PostRetrievalService postRetrievalService, PostCreationService postCreationService,
                          PostUpdateService postUpdateService, PostDeletionService postDeletionService) {
        this.postRetrievalService = postRetrievalService;
        this.postCreationService = postCreationService;
        this.postUpdateService = postUpdateService;
        this.postDeletionService = postDeletionService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRetrievalService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postRetrievalService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postCreationService.createPost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        return ResponseEntity.ok(postUpdateService.updatePost(id, postDetails));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(postUpdateService.patchPost(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postDeletionService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}