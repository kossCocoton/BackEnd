package com.example.cokothon.emotion.controller;

import com.example.cokothon.emotion.dto.EmotionCountListDto;
import com.example.cokothon.emotion.repository.EmotionRepository;
import com.example.cokothon.emotion.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionController {

    private final EmotionService emotionService;

    @GetMapping
    public EmotionCountListDto getAllEmotions() {
        return emotionService.findAllEmotions();
    }

}
