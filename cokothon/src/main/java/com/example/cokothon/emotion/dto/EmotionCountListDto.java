package com.example.cokothon.emotion.dto;

import java.util.List;

public record EmotionCountListDto(
        int total,
        List<EmotionListReponse> emotions
) {
    public EmotionCountListDto(int total, List<EmotionListReponse> emotions){
        this.total = total;
        this.emotions = emotions;
    }
}
