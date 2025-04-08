package org.example.board.domain.image.service.impl;

import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageUploadService;
import org.example.board.global.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    private final ImageRepository imageRepository;
    private final String uploadDir = "uploads";

    public ImageUploadServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    @Transactional
    public Image uploadImage(MultipartFile file) throws IOException {
        String storedFileName = FileUtil.saveFile(file, uploadDir);
        
        Image image = Image.builder()
                .originalFileName(file.getOriginalFilename())
                .storedFileName(storedFileName)
                .filePath(uploadDir + "/" + storedFileName)
                .fileType(file.getContentType())
                .build();
                
        return imageRepository.save(image);
    }
} 