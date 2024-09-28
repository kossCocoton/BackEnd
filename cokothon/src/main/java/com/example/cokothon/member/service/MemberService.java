package com.example.cokothon.member.service;

import com.example.cokothon.member.dto.MemberDto;
import com.example.cokothon.member.dto.MemberLoginDto;
import com.example.cokothon.member.entity.Member;

public interface MemberService {
    Member createMember(MemberDto memberDto);

    boolean loginMember(MemberLoginDto memberLoginDto);
}
