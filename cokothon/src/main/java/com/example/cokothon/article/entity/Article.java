package com.example.cokothon.article.entity;

import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.categoryList.Entity.CategoryList;
import com.example.cokothon.common.BaseTimeEntity;
import com.example.cokothon.member.entity.Member;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Article extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "article_id",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "catlist_id")
    private CategoryList categoryList;

    @Builder
    public Article(String title, String content, CategoryList categoryList) {
        this.title = title;
        this.content = content;
    }

    public void changeCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    public void changeMember(Member member) {
        this.member = member;
        member.getArticles().add(this);
    }
}
