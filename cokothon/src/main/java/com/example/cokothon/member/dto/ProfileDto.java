package com.example.cokothon.member.dto;

import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.stress.dto.StressDto;
import com.example.cokothon.stress.entity.Stress;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ProfileDto {
    String nickname;
    List<DiaryResponse> diaryList;
    List<StressDto> stressList;
}
