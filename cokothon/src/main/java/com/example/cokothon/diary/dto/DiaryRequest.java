package com.example.cokothon.diary.dto;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;

public record DiaryRequest(
        String title,
        String content,
        String emoji,
        int stress
) {
    public Diary toEntity(Member member) {
        return new Diary(
                title,
                emoji,
                stress,
                content,
                member
        );
    }
}
