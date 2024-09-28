package com.example.cokothon.categoryList.Entity;


import com.example.cokothon.article.entity.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CategoryList {

    @Id @GeneratedValue()
    @Column(name = "catlist_id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;


    @OneToOne(mappedBy = "categoryList", fetch = FetchType.LAZY)
    @JsonIgnore

    private Article article;

    public CategoryList(CategoryEnum category) {
        this.category = category;
    }



}
