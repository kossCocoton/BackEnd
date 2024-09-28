package com.example.cokothon.member.service;

import com.example.cokothon.member.dto.MemberDto;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    //private final PasswordEncoder passwordEncoder;
    @Override
    public Member createMember(MemberDto memberDto) {
        // Username 중복 확인
        Optional<Member> existingMemberByUsername = memberRepository.findByUsername(memberDto.getUsername());
        if (existingMemberByUsername.isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }

        // Nickname 중복 확인
        Optional<Member> existingMemberByNickname = memberRepository.findByNickname(memberDto.getNickname());
        if (existingMemberByNickname.isPresent()) {
            throw new IllegalArgumentException("Nickname already exists!");
        }

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .nickname(memberDto.getNickname())
                .age(memberDto.getAge())
                .job(memberDto.getJob())
                .gender(memberDto.getGender()).build();

        memberRepository.save(member);
        return member;
    }

    @Override
    public Member findByUserName(String userName) throws Exception {
        Optional<Member> existingMemberByUsername = memberRepository.findByUsername(userName);
        if (existingMemberByUsername.isPresent()) {
            return existingMemberByUsername.get();
        }
        throw new Exception();
    }
}
