package org.example.board.domain.image.service;

import org.example.board.domain.image.entity.Image;
import java.util.List;

public interface ImageRetrievalService {
    List<Image> getAllImages();
    Image getImage(Long id);
} 