package com.example.cokothon.diary.dto;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;

public record DiaryResponse(
        Long id,
        String title,
        String emoji,
        String content,
        int stress,
        String date
) {
    public static DiaryResponse fromEntity(Diary diary) {
        return new DiaryResponse(
                diary.getId(),
                diary.getTitle(),
                diary.getEmoji(),
                diary.getContent(),
                diary.getStress(),
                diary.getDate()
        );
    }
}
