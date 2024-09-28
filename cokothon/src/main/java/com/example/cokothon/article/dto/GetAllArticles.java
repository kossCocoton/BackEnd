package com.example.cokothon.article.dto;

import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.categoryList.Entity.CategoryList;
import com.example.cokothon.member.entity.Age;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import lombok.Builder;
import lombok.Data;

@Data

public class GetAllArticles {

    private Long id;

    private String title;
    private String content;

    private CategoryEnum category;

    private Age age;        // 작성한 멤버의 나이
    private Gender gender;  // 작성한 멤버의 성별
    private Job job;        // 작성한 멤버의 직업

    private String date;

    @Builder
    public GetAllArticles(Long id, String title, String content, CategoryEnum category, Age age, Gender gender, Job job, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.date = date;
    }
}
