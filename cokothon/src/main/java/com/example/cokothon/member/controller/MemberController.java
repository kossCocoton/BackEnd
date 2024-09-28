package com.example.cokothon.member.controller;

import com.example.cokothon.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
}
