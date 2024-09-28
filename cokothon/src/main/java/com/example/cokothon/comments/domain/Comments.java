package com.example.cokothon.comments.domain;

import com.example.cokothon.article.entity.Article;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @Builder
    public Comments(String writerId, String content) {
        this.writerId = writerId;
        this.content = content;
    }


}
