package com.example.cokothon.article.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FitterArticle {

    private String title;
    private String content;

}
