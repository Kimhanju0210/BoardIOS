package org.example.board.domain.image.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.service.ImageConversionService;
import org.example.board.domain.image.service.ImageDeletionService;
import org.example.board.domain.image.service.ImageRetrievalService;
import org.example.board.domain.image.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageUploadService imageUploadService;
    private final ImageRetrievalService imageRetrievalService;
    private final ImageDeletionService imageDeletionService;
    private final ImageConversionService imageConversionService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        Image image = imageUploadService.uploadImage(file);
        return ResponseEntity.ok(imageConversionService.convertImageToMap(image));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        List<Map<String, Object>> images = imageRetrievalService.getAllImages()
                .stream()
                .map(imageConversionService::convertImageToMap)
                .collect(Collectors.toList());
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getImage(@PathVariable Long id) {
        Image image = imageRetrievalService.getImage(id);
        return ResponseEntity.ok(imageConversionService.convertImageToMap(image));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageDeletionService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
} 