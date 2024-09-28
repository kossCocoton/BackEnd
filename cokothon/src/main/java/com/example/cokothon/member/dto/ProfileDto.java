package com.example.cokothon.member.dto;

import com.example.cokothon.diary.entity.Diary;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ProfileDto {
    String nickname;
    List<Diary> diaryList;
}
