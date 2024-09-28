package com.example.cokothon.member.entity;

import com.example.cokothon.article.entity.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @OneToMany(mappedBy = "member")
    List<Article> articles;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Age age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Job job;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
