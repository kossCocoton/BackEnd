package com.example.cokothon.categoryList.Entity;


import com.example.cokothon.article.entity.Article;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CategoryList {

    @Id @GeneratedValue()
    @Column(name = "catlist_id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;

    public CategoryList(CategoryEnum category) {
        this.category = category;
    }

    public void changeArticle(Article article){
        this.article = article;
    }

}
