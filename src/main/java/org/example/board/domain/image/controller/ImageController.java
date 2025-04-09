package org.example.board.domain.image.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.service.ImageDeletionService;
import org.example.board.domain.image.service.ImageRetrievalService;
import org.example.board.domain.image.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageUploadService imageUploadService;
    private final ImageRetrievalService imageRetrievalService;
    private final ImageDeletionService imageDeletionService;

    @PostMapping
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(imageUploadService.uploadImage(file));
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok(imageRetrievalService.getAllImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImage(@PathVariable Long id) {
        return ResponseEntity.ok(imageRetrievalService.getImage(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageDeletionService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
} 