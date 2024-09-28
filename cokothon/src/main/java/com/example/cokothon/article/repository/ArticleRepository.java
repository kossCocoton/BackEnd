package com.example.cokothon.article.repository;


import com.example.cokothon.article.entity.Article;
import com.example.cokothon.categoryList.Entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select a from Article a join fetch a.categoryList c where c.category = :categoryEnum")
    public List<Article> findJobFitter(@Param("category") CategoryEnum categoryEnum);

}
