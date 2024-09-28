package com.example.cokothon.article.controller;

import com.example.cokothon.article.dto.CreateArticle;
import com.example.cokothon.article.dto.GetAllArticles;
import com.example.cokothon.article.dto.GetMyArticle;
import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.article.service.ArticleService;
import com.example.cokothon.categoryList.Entity.CategoryEnum;
import com.example.cokothon.member.entity.Gender;
import com.example.cokothon.member.entity.Job;
import com.example.cokothon.member.entity.Member;
import com.example.cokothon.stress.entity.Stress;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    //게시물 등록
    @PostMapping("/api/article")
    public ResponseEntity<String> createArticle(HttpSession session,
                                              @RequestBody CreateArticle createArticle) {


        Member memberInSession = (Member) session.getAttribute("logined");

        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }

        articleService.saveArticle(createArticle, memberInSession);

        return ResponseEntity.status(HttpStatus.CREATED).body("회원 저장 성공");
    }

    //전체 게시물 조회
    @GetMapping("/api/articles")
    public ResponseEntity<Object> getAllArticles(HttpSession session) {

        Member memberInSession = (Member) session.getAttribute("logined");

        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }

        List<Article> articles = articleService.getAllArticles();

        //dto 변환
        List <GetAllArticles> getAllArticles = articles.stream()
                .map(a -> GetAllArticles.builder()
                        .title(a.getTitle())
                        .content(a.getContent())
                        .build()).toList();

        return ResponseEntity.ok().body(getAllArticles);
    }

    @GetMapping("/api/myarticle")
    public ResponseEntity<Object> getMyArticles(HttpSession session) {
        Member memberInSession = (Member) session.getAttribute("logined");
        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }

        GetMyArticle getMyArticle =  articleService.getMyArticle(memberInSession.getMember_id());

        if (getMyArticle == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(getMyArticle);
        }

    }

    @GetMapping("/api/article")
    public ResponseEntity<Object> getArticle(HttpSession session,
                                             @RequestParam(name = "job") Job job,
                                             @RequestParam(name = "gender") Gender gender,
                                             @RequestParam(name = "situation")CategoryEnum category) {
        /*
        Member memberInSession = (Member) session.getAttribute("logined");
        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }
        */



        return ResponseEntity.ok().body(
                articleService.fitterArticle(job, gender, category));


    }




}
