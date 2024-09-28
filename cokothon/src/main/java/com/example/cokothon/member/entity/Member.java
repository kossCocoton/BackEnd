package com.example.cokothon.member.entity;

import com.example.cokothon.article.entity.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(nullable = false)
    @GeneratedValue()
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
