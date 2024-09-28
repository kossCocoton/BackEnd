package com.example.cokothon.diary.service;

import com.example.cokothon.diary.dto.DiaryRequest;
import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.dto.DiaryUpdateRequest;
import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.diary.repository.DiaryRepository;
import com.example.cokothon.emotion.entity.Emotion;
import com.example.cokothon.emotion.repository.EmotionRepository;
import com.example.cokothon.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final EmotionRepository emotionRepository;


    public DiaryResponse createDiary(DiaryRequest dto, Member member) {
        Diary diary = dto.toEntity(member);
        Diary savedDiary = diaryRepository.save(diary);
        return DiaryResponse.fromEntity(savedDiary);
    }

    public void updateDiary(Long diaryId, DiaryUpdateRequest updateRequest) {
        Optional<Diary> optionalDiary = diaryRepository.findById(diaryId);

        if (optionalDiary.isPresent()) {
            Diary diary = optionalDiary.get();
            diary.setEmoji(updateRequest.emoji());
            diary.setStress(updateRequest.stress());

            diaryRepository.save(diary);
        } else {
            throw new IllegalArgumentException("Invalid diary ID: " + diaryId);
        }
    }

    public void deleteDiary(Long diaryId){
        Optional<Diary> optionalDiary = diaryRepository.findById(diaryId);

        if (optionalDiary.isPresent()){
            Diary diary = optionalDiary.get();

            Emotion emotion = Emotion.builder()
                    .emoji(diary.getEmoji())
                    .stress(diary.getStress())
                    .build();

            emotionRepository.save(emotion);

            diaryRepository.deleteById(diaryId);
        } else {
            throw new IllegalArgumentException("Invalid diary ID: " + diaryId);
        }
    }

}
