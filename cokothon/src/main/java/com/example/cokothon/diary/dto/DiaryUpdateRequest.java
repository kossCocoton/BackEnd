package com.example.cokothon.diary.dto;

public record DiaryUpdateRequest(
        String emoji,
        int stress
) {
}
