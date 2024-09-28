package com.example.cokothon.article.dto;

import lombok.Builder;
import lombok.Data;

@Data

public class GetAllArticles {

    private String title;
    private String content;

    @Builder
    public GetAllArticles(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
