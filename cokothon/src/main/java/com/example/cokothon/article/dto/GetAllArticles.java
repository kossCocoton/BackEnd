package com.example.cokothon.article.dto;

import com.example.cokothon.categoryList.Entity.CategoryList;
import lombok.Builder;
import lombok.Data;

@Data

public class GetAllArticles {

    private Long id;

    private String title;
    private String content;

    private CategoryList categoryList;

    @Builder
    public GetAllArticles(Long id, String title, String content, CategoryList categoryList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryList = categoryList;
    }
}
