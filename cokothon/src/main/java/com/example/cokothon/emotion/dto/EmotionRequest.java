package com.example.cokothon.emotion.dto;

import com.example.cokothon.emotion.entity.Emotion;

public record EmotionRequest(
        String emoji
) {
    public Emotion toEntity(){
        return new Emotion(
                emoji
        );
    }
}
