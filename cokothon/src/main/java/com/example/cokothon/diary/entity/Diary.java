package com.example.cokothon.diary.entity;

import com.example.cokothon.common.BaseTimeEntity;
import com.example.cokothon.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "confirm")
public class Diary extends BaseTimeEntity {

    @Id @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String emoji;

    @Column(nullable = false)
    private String content;

    @Column
    private int stress;

    @Column(nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Diary(String title, String emoji, String content, int stress, String date, Member member){
        this.title = title;
        this.emoji = emoji;
        this.content = content;
        this.stress = stress;
        this.date = date;
        this.member = member;
    }
}
