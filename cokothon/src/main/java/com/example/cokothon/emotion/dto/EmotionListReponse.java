package com.example.cokothon.emotion.dto;

import com.example.cokothon.emotion.entity.Emotion;
import lombok.Builder;

@Builder
public record EmotionListReponse(
        String emoji,
        int stress
) {
    public static EmotionListReponse toEmotionList(Emotion emotion){
        return EmotionListReponse.builder()
                .emoji(emotion.getEmoji())
                .stress(emotion.getStress())
                .build();
    }
}
