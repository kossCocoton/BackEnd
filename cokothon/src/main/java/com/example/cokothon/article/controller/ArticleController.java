package com.example.cokothon.article.controller;

import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/api/article")
    public ResponseEntity<Void> createArticle(@RequestBody CreateArticle createArticle) {

        articleService.saveArticle(createArticle);

        return ResponseEntity.ok().build();
    }



}
