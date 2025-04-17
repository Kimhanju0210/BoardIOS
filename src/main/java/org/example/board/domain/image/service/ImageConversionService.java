package org.example.board.domain.image.service;

import org.example.board.domain.image.entity.Image;
import java.util.Map;

public interface ImageConversionService {
    Map<String, Object> convertImageToMap(Image image);
} 