package org.example.board.global.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Slf4j
@Configuration
public class AppConfig {
    @Value("${IMAGE_DOWNLOAD_URL}")
    private String baseUrl;

    @PostConstruct
    public void init() {
        log.info("AppConfig initialized with baseUrl: {}", baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }
} 