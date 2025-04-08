package org.example.board.domain.image.service;

import org.example.board.domain.image.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {
    Image uploadImage(MultipartFile file) throws IOException;
} 