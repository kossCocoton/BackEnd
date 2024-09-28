package com.example.cokothon.article.entity;

import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.categoryList.Entity.CategoryList;
import com.example.cokothon.comments.domain.Comments;
import com.example.cokothon.common.BaseTimeEntity;
import com.example.cokothon.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Article extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "article_id",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Comments> comments = new ArrayList<>();

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "catlist_id")
    private CategoryList categoryList;

    @Builder
    public Article(String title, String content, CategoryList categoryList) {
        this.title = title;
        this.content = content;
        this.categoryList = categoryList;
    }

    public void changeCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
        categoryList.setArticle(this);
    }

    public void changeMember(Member member) {
        this.member = member;
        if (member.getArticles() == null){
            member.setArticles(new ArrayList<Article>());
        }
        member.getArticles().add(this);
    }

    public void changeComments(Comments comments){
        this.comments.add(comments);
        comments.setArticle(this);
    }
}
