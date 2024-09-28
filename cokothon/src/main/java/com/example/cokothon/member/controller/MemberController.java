package com.example.cokothon.member.controller;

import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.entity.Diary;
import com.example.cokothon.diary.repository.DiaryRepository;
import com.example.cokothon.diary.service.DiaryService;
import com.example.cokothon.member.dto.ProfileDto;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.service.MemberService;
import com.example.cokothon.stress.dto.StressDto;
import com.example.cokothon.stress.entity.Stress;
import com.example.cokothon.stress.service.StressService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/my")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final DiaryRepository diaryRepository;
    private final StressService stressService;

    @GetMapping()
    public ResponseEntity<?> getProfile(
            HttpSession session
    ) {
        Member member = (Member) session.getAttribute("logined");
        List<Diary> diaryList = diaryRepository.findAllById(member);
        List<Stress> stressList = stressService.getAllStress(member.getMember_id());

        List<DiaryResponse> diaryDtoList = diaryList.stream()
                .map(diary -> new DiaryResponse(diary.getId(), diary.getTitle(), diary.getEmoji(),
                        diary.getStress(), diary.getContent(), diary.getCreatedAt()))
                .collect(Collectors.toList());

        List<StressDto> stressDtoList = stressList.stream()
                .map(stress -> new StressDto(stress.getMember().getMember_id(), stress.getStress(),
                        stress.getCreatedAt()))
                .collect(Collectors.toList());

        ProfileDto profileDto = ProfileDto.builder()
                .nickname(member.getNickname())
                .diaryList(diaryDtoList)
                .stressList(stressDtoList)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(profileDto);
    }
}
