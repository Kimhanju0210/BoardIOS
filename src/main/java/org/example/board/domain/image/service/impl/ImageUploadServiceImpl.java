package org.example.board.domain.image.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.repository.ImageRepository;
import org.example.board.domain.image.service.ImageUploadService;
import org.example.board.global.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageUploadServiceImpl implements ImageUploadService {

    private final ImageRepository imageRepository;

    @Value("${IMAGE_UPLOAD_DIR}")
    private String uploadDir;  // 이미지가 저장될 서버 디렉토리

    @Override
    @Transactional
    public Image uploadImage(MultipartFile file) throws IOException {
        // 1. 파일을 서버의 uploads 디렉토리에 저장
        String storedFileName = FileUtil.saveFile(file, uploadDir);
        
        // 2. 저장된 파일 정보로 이미지 엔티티 생성
        Image image = Image.builder()
                .originalFileName(file.getOriginalFilename())  // 원본 파일명
                .storedFileName(storedFileName)                // 서버에 저장된 파일명
                .filePath(uploadDir + "/" + storedFileName)   // 파일 전체 경로
                .fileType(file.getContentType())              // 파일 타입 (예: image/jpeg)
                .build();
                
        // 3. 이미지 정보를 데이터베이스에 저장하고 반환
        return imageRepository.save(image);
    }
} 