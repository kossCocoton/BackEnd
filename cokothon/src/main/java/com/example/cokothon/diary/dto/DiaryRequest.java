package com.example.cokothon.diary.dto;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;

public record DiaryRequest(
        String title,
        String emoji,
        String content,
        int stress,
        String date
) {
    public Diary toEntity(Member member) {
        return new Diary(
                title,
                emoji,
                content,
                stress,
                date,
                member
        );
    }
}
