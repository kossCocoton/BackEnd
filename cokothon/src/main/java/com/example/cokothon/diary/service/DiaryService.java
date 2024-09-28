package com.example.cokothon.diary.service;

import com.example.cokothon.diary.dto.DiaryRequest;
import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.diary.repository.DiaryRepository;
import com.example.cokothon.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;


    public DiaryResponse createDiary(DiaryRequest dto, Member member) {
        Diary diary = dto.toEntity(member);
        Diary savedDiary = diaryRepository.save(diary);
        return DiaryResponse.fromEntity(savedDiary);
    }



}
