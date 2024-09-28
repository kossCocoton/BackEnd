package com.example.cokothon.comments.dto;

import lombok.Data;

@Data
public class AddComments {

    private String content;
    private String writer_id;
    private Long article_id;

}
