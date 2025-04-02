package org.example.board.domain.image.service.impl;

import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageUploadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    private final ImageRepository imageRepository;

    public ImageUploadServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    @Transactional
    public Image uploadImage(String contentImage) {
        Image image = Image.builder()
                .contentImage(contentImage)
                .build();
        return imageRepository.save(image);
    }
} 