package com.example.cokothon.diary.entity;

import com.example.cokothon.common.BaseTimeEntity;
import com.example.cokothon.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Diary extends BaseTimeEntity {

    @Id @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String emoji;

    private int stress;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Diary(String title, String emoji, int stress, String content, String date, Member member){
        this.title = title;
        this.emoji = emoji;
        this.stress = stress;
        this.content = content;
        this.date = date;
        this.member = member;
    }

}
