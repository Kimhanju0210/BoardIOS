package org.example.board.global.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtil {
    public static String saveFile(MultipartFile file, String uploadDir) throws IOException {
        // 업로드 디렉토리가 없으면 생성
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 원본 파일명
        String originalFileName = file.getOriginalFilename();
        
        // 저장할 파일명 생성 (UUID + 확장자)
        String storedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
        
        // 파일 저장
        Path filePath = Paths.get(uploadDir, storedFileName);
        Files.copy(file.getInputStream(), filePath);

        return storedFileName;
    }
} 