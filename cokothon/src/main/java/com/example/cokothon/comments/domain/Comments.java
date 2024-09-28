package com.example.cokothon.comments.domain;

import com.example.cokothon.article.entity.Article;
import jakarta.persistence.*;

@Entity
public class Comments {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(nullable = false, name = "writer_id")
    private String writerId;

    @Column(nullable = false)
    private String content;

}
