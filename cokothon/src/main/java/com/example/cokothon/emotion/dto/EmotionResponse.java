package com.example.cokothon.emotion.dto;

import com.example.cokothon.emotion.entity.Emotion;

public record EmotionResponse(
        String emoji
) {
    public static EmotionResponse fromEntity(Emotion emotion){
        return new EmotionResponse(
                emotion.getEmoji()
        );
    }
}
