package com.example.cokothon.diary.entity;

import com.example.cokothon.common.BaseTimeEntity;
import jakarta.persistence.*;

public class Diary extends BaseTimeEntity {

    @Id @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emoji;

    @Column(nullable = false)
    private String content;

    @Column
    private int stress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
