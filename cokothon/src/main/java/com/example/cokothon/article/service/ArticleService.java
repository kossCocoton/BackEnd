package com.example.cokothon.article.service;


import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.categoryList.Entity.CategoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Long saveArticle(CreateArticle createArticle) {
        CategoryList categoryList =
                new CategoryList(createArticle.getCategory());

        Article article = Article.builder()
                .title(createArticle.getTitle())
                .content(createArticle.getContent())
                .categoryList(categoryList)
                .build();

        article.changeCategoryList(categoryList);
        categoryList.changeArticle(article);

        return articleRepository.save(article).getId();
    }

}
