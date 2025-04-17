package org.example.board.domain.image.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageRetrievalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageRetrievalServiceImpl implements ImageRetrievalService {

    private final ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found with id: " + id));
    }
} 