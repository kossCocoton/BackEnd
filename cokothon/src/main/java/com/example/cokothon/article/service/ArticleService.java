package com.example.cokothon.article.service;


import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.categoryList.Entity.CategoryList;
import com.example.cokothon.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Long saveArticle(CreateArticle createArticle, Member member) {



        CategoryList categoryList =
                new CategoryList(createArticle.getCategory());

        Article article = Article.builder()
                .title(createArticle.getTitle())
                .content(createArticle.getContent())
                .categoryList(categoryList)
                .build();

        //멤버 정보 받아서 연관관계 저장

        article.changeCategoryList(categoryList);
        article.changeMember(member);
        categoryList.changeArticle(article);

        return articleRepository.save(article).getId();
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

}
