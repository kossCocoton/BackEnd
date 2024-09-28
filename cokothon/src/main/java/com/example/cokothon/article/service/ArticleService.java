package com.example.cokothon.article.service;


import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.dto.FitterArticle;
import com.example.cokothon.article.dto.GetMyArticle;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.categoryList.Entity.CategoryList;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.stress.entity.Stress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public GetMyArticle getMyArticle(Long member_id) {
        Optional<Article> article =  articleRepository.findById(member_id);

        if (article.isPresent()) {
            Article tempArticle = article.get();
            return GetMyArticle.builder()
                    .title(tempArticle.getTitle())
                    .content(tempArticle.getContent())
                    .build();
        }else{
            return null;
        }

    }

    public List<FitterArticle> fitterArticle(Job job, Gender gender,
                                       CategoryEnum category){

        List<Article> articles = articleRepository.
                findSituationFitter(category,gender,job);




        List<FitterArticle> fitterArticles = articles.stream()
                .map(article -> FitterArticle.builder()
                        .title(article.getTitle())
                        .content(article.getContent())
                        .build()
                )
                .toList();

        return fitterArticles;

    }

}
