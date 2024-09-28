package com.example.cokothon.emotion.controller;

import com.example.cokothon.emotion.dto.EmotionCountListDto;
import com.example.cokothon.emotion.dto.EmotionRequest;
import com.example.cokothon.emotion.dto.EmotionResponse;
import com.example.cokothon.emotion.repository.EmotionRepository;
import com.example.cokothon.emotion.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/emotion")
public class EmotionController {

    private final EmotionService emotionService;

    @GetMapping
    public EmotionCountListDto getAllEmotions() {
        return emotionService.findAllEmotions();
    }

    @PostMapping
    public EmotionResponse createEmotion(@RequestBody EmotionRequest dto){
        return emotionService.createEmotion(dto);
    }

}
