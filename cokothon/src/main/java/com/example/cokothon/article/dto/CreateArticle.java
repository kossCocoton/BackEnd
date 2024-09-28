package com.example.cokothon.article.dto;


import com.example.cokothon.article.entity.Article;
import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.categoryList.Entity.CategoryList;
import lombok.Data;

@Data
public class CreateArticle {
    private String title;
    private String content;
    private CategoryEnum category;

}
