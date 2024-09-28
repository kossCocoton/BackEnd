package com.example.cokothon.emotion.service;

import com.example.cokothon.emotion.dto.EmotionCountListDto;
import com.example.cokothon.emotion.dto.EmotionListReponse;
import com.example.cokothon.emotion.dto.EmotionRequest;
import com.example.cokothon.emotion.dto.EmotionResponse;
import com.example.cokothon.emotion.entity.Emotion;
import com.example.cokothon.emotion.repository.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;

    public EmotionCountListDto findAllEmotions(){
        List<Emotion> emotionList = emotionRepository.findAll();

        List<EmotionListReponse> emotionDtoList = emotionList.stream()
                .map(EmotionListReponse::toEmotionList)
                .toList();

        return new EmotionCountListDto(emotionList.size(), emotionDtoList);
    }

    public EmotionResponse createEmotion(EmotionRequest dto){
        Emotion emotion = dto.toEntity();
        Emotion savedEmotion = emotionRepository.save(emotion);
        return EmotionResponse.fromEntity(savedEmotion);
    }
}
