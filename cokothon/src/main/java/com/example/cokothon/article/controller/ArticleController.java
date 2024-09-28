package com.example.cokothon.article.controller;

import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.dto.GetAllArticles;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    //게시물 등록
    @PostMapping("/api/article")
    public ResponseEntity<Void> createArticle(@RequestBody CreateArticle createArticle) {

        articleService.saveArticle(createArticle);

        return ResponseEntity.ok().build();
    }

    //전체 게시물 조회
    @GetMapping("/api/articles")
    public ResponseEntity<List<GetAllArticles>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();

        //dto 변환
        List <GetAllArticles> getAllArticles = articles.stream()
                .map(a -> GetAllArticles.builder()
                        .title(a.getTitle())
                        .content(a.getContent())
                        .build()).toList();

        return ResponseEntity.ok().body(getAllArticles);
    }



}
