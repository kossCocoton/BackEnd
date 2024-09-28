package com.example.cokothon.member.controller;

import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    @GetMapping()
//    public ResponseEntity<?> getProfile(
//            HttpServletRequest request
//    ) {
//        HttpSession session = request.getSession();
//        Member memberInSession = (Member) session.getAttribute("logined");
//    }
}
