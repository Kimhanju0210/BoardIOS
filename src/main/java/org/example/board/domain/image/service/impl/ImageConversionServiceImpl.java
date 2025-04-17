package org.example.board.domain.image.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.image.entity.Image;
import org.example.board.domain.image.service.ImageConversionService;
import org.example.board.global.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageConversionServiceImpl implements ImageConversionService {

    private final AppConfig appConfig;
    
    @PostConstruct
    public void init() {
        log.info("ImageConversionServiceImpl initialized with baseUrl: {}", 
                appConfig.getBaseUrl());
    }

    @Override
    public Map<String, Object> convertImageToMap(Image image) {
        log.debug("Converting image to map: {}", image);
        Map<String, Object> response = new HashMap<>();
        response.put("id", image.getId());
        response.put("originalFileName", image.getOriginalFileName());
        response.put("storedFileName", image.getStoredFileName());
        response.put("filePath", image.getFilePath());
        response.put("fileType", image.getFileType());
        
        String imageUrl = "/images/" + image.getStoredFileName();
        log.info("Generated imageUrl: {}", imageUrl);
        
        response.put("imageUrl", imageUrl);
        return response;
    }
}