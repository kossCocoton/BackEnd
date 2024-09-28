package com.example.cokothon.emotion.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Emotion {

    @Id @Column(name = "emotion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emoji;

    @Column(nullable = false)
    private int stress;

    @Builder
    public Emotion (String emoji, int stress){
        this.emoji = emoji;
        this.stress = stress;
    }
}
