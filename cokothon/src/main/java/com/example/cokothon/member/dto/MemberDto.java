package com.example.cokothon.member.dto;

import com.example.cokothon.member.entity.Age;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MemberDto {
    String username;
    String password;
    String nickname;
    Age age;
    Job job;
    Gender gender;
}
