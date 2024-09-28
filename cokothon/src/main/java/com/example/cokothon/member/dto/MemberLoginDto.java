package com.example.cokothon.member.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MemberLoginDto {
    String username;
    String password;
}
