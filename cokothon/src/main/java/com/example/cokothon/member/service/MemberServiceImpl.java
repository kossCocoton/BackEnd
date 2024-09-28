package com.example.cokothon.member.service;

import com.example.cokothon.member.dto.MemberDto;
import com.example.cokothon.member.dto.MemberLoginDto;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
//import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 8c25c99af4477b6e9e38fcd6e11e24326a51f20d
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
<<<<<<< HEAD
=======

    //private final PasswordEncoder passwordEncoder;

>>>>>>> 8c25c99af4477b6e9e38fcd6e11e24326a51f20d
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
    // 로그인 시 비밀번호 일치 여부 확인
    public boolean loginMember(MemberLoginDto memberLoginDto) {
        Optional<Member> optionalMember = memberRepository.findByUsername(memberLoginDto.getUsername());

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            // 입력된 비밀번호와 DB에 저장된 비밀번호의 일치 여부 확인
            if (member.getPassword().equals(memberLoginDto.getPassword())) {
                // 비밀번호가 일치하면 로그인 성공
                return true;
            }
        }
        // 로그인 실패
        return false;
    }

}
