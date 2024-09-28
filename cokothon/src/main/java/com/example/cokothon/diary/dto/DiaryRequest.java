package com.example.cokothon.diary.dto;

import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.member.entity.Member;

public record DiaryRequest(
        String title,
        String content,
        String date
) {
    public Diary toEntity(Member member) {
        return new Diary(
                title,
                content,
                date,
                member
        );
    }
}
