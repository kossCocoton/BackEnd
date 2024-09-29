package com.example.cokothon.diary.controller;


import com.example.cokothon.diary.dto.DiaryRequest;
import com.example.cokothon.diary.dto.DiaryResponse;
import com.example.cokothon.diary.dto.DiaryUpdateRequest;
import com.example.cokothon.diary.service.DiaryService;
import com.example.cokothon.member.entity.Age;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import com.example.cokothon.member.service.MemberService;
import com.example.cokothon.stress.dto.StressDto;
import com.example.cokothon.stress.service.StressService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService diaryService;

    private final StressService stressService;
    private final MemberRepository memberRepository;
    private final MemberService memberService;


    @PostMapping
    public DiaryResponse createDiary(@RequestBody DiaryRequest diaryRequestDto, HttpSession session) throws Exception {
//        Member member = (Member) session.getAttribute("logined");
//        if (member == null) {
//            throw new IllegalArgumentException("로그인된 회원 정보가 없습니다.");
//        }
        Member member = memberService.findByUserName("nykim1016");
        return diaryService.createDiary(diaryRequestDto, member);
    }

    @PostMapping("/stress/{diary_id}")
    public ResponseEntity<Void> updateDiary(@PathVariable("diary_id") Long diaryId,
                                                          @RequestBody DiaryUpdateRequest updateRequest, HttpSession session) {
        Member member = (Member) session.getAttribute("logined");
        if (member == null) {
            throw new IllegalArgumentException("로그인 된 회원 정보가 없습니다.");
        }

        StressDto stressDto = StressDto.builder()
                                        .memberId(member.getMember_id())
                                        .stress(updateRequest.stress())
                                        .build();

        diaryService.updateDiary(diaryId, updateRequest);
        stressService.createStress(stressDto);

        return ResponseEntity.noContent().build(); // 성공 시 204 No Content 반환
    }

    @PostMapping("/{diary_id}")
    public void deleteDiary(@PathVariable("diary_id") Long diaryId) {
        diaryService.deleteDiary(diaryId);
    }

}

