package com.example.cokothon.diary.dto;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;

public record DiaryResponse(
        Long id,
        String title,
        String content,
        String date
) {
    public static DiaryResponse fromEntity(Diary diary) {
        return new DiaryResponse(
                diary.getId(),
                diary.getTitle(),
                diary.getContent(),
                diary.getDate()
        );
    }
}
