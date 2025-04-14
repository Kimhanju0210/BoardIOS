package org.example.board.domain.image.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageDeletionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageDeletionServiceImpl implements ImageDeletionService {

    private final ImageRepository imageRepository;
    
    @Value("${IMAGE_UPLOAD_DIR}")
    private String uploadDir;

    @Override
    @Transactional
    public void deleteImage(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found with id: " + id));
                
        // 실제 파일 삭제
        try {
            Path filePath = Paths.get(uploadDir, image.getStoredFileName());
            Files.deleteIfExists(filePath);
            log.info("Successfully deleted file: {}", filePath);
        } catch (Exception e) {
            log.error("Failed to delete file: {}", image.getStoredFileName(), e);
            throw new RuntimeException("Failed to delete image file", e);
        }
        
        // DB에서 레코드 삭제
        imageRepository.delete(image);
        log.info("Successfully deleted image record from database with id: {}", id);
    }
}