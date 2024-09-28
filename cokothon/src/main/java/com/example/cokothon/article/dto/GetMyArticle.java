package com.example.cokothon.article.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMyArticle {

    private String title;
    private String content;
}
