package com.example.cokothon.diary.controller;


import com.example.cokothon.diary.dto.DiaryRequest;
import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.service.DiaryService;
import com.example.cokothon.member.entity.Age;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService diaryService;
    private final MemberRepository memberRepository;


    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest diaryRequestDto, HttpSession session) {
        Member member = (Member) session.getAttribute("logined");
        if (member == null) {
            throw new IllegalArgumentException("로그인된 회원 정보가 없습니다.");
        }

        return diaryService.createDiary(diaryRequestDto, member);
    }


}

