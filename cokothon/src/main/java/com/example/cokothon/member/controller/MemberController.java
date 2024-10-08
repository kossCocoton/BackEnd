package com.example.cokothon.member.controller;

import com.example.cokothon.member.dto.MemberDto;
import com.example.cokothon.member.dto.MemberLoginDto;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import com.example.cokothon.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    private HttpSession httpSession;

    private HttpSession regenerateSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate(); // 기존 세션 무효화
        return request.getSession(true); // 새로운 세션 생성하여 반환
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createMember(
            HttpServletRequest request, @RequestBody MemberDto memberDto
    )
    {
        HttpSession session = request.getSession();

        // 중복된 회원 확인
        Optional<Member> existingMember = memberRepository.findByUsername(memberDto.getUsername());

        if (existingMember.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists.");
        }

        // 중복이 없으면 새로운 회원 생성
        Member member = memberService.createMember(memberDto);
        session = regenerateSession(request); // 새로운 세션 생성
        session.setAttribute("logined", member);

        // 세션에 잘 저장되었는지 확인
        Member memberInSession = (Member) session.getAttribute("logined");
        System.out.println("회원 ID: " + memberInSession.getUsername());

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(
            HttpServletRequest request, @RequestBody MemberLoginDto memberLoginDto
            ) {
        // 1. 사용자 조회
        Optional<Member> optionalMember = memberRepository.findByUsername(memberLoginDto.getUsername());

        // 2. 사용자 존재 여부 확인
        if (!optionalMember.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        Member member = optionalMember.get();

//        // 3. 비밀번호 일치 여부 확인
//        if (!passwordEncoder.matches(memberLoginDto.getPassword(), member.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }

        // 4. 세션에 사용자 정보 저장
        HttpSession session = request.getSession(true);  // 새로운 세션 생성 또는 기존 세션 사용
        session.setAttribute("logined", member);  // 세션에 로그인된 사용자 저장

        // 5. 로그인 성공 응답
        return ResponseEntity.status(HttpStatus.OK).body("Login successful");
    }

}
