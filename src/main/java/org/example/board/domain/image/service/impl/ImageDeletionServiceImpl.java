package org.example.board.domain.image.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageDeletionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageDeletionServiceImpl implements ImageDeletionService {

    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public void deleteImage(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found with id: " + id));
        imageRepository.delete(image);
    }
}