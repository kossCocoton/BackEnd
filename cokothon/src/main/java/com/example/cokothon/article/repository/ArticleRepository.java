package com.example.cokothon.article.repository;


import com.example.cokothon.article.entity.Article;
import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select a from Article a join fetch a.categoryList c join fetch a.member m" +
            " where c.category = :category or m.gender = :gender or m.job = :job")
    public List<Article> findSituationFitter(@Param("category") CategoryEnum categoryEnum,
                                             @Param("gender")Gender gender,
                                             @Param("job") Job job);

    @Modifying
    @Query("DELETE FROM Article a WHERE a.member.member_id = :member_id AND a.id = :article_id ")
    public void deleteArticle(@Param("member_id") Long member_id,@Param("article_id") Long article_id);

    @Query("select a from Article a join fetch a.categoryList")
    public List<Article> findAllCategories();


}
