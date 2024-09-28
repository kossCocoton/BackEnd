package com.example.cokothon.stress.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StressDto {
    private String memberId;
    private Integer stress;
}
