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
import com.example.cokothon.member.service.MemberService;
import com.example.cokothon.stress.entity.Stress;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;

    //게시물 등록
    @PostMapping("/api/article")
    public ResponseEntity<String> createArticle(HttpSession session,
                                              @RequestBody CreateArticle createArticle) throws Exception {


//        Member memberInSession = (Member) session.getAttribute("logined");
//
//        if (memberInSession == null) {
//            return ResponseEntity.badRequest().body("로그인 하세요");
//        }
        Member member = memberService.findByUserName("nykim1016");

        articleService.saveArticle(createArticle, member);

        return ResponseEntity.status(HttpStatus.CREATED).body("회원 저장 성공");
    }

    //전체 게시물 조회
    @GetMapping("/api/articles")
    public ResponseEntity<Object> getAllArticles(HttpSession session) {

        Member memberInSession = (Member) session.getAttribute("logined");

        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }

        List<Article> articles = articleService.getAllCategory();

        //dto 변환
        List <GetAllArticles> getAllArticles = articles.stream()
                .map(a -> GetAllArticles.builder()
                        .id(a.getId())
                        .title(a.getTitle())
                        .content(a.getContent())
                        .category(a.getCategoryList().getCategory())
                        .age(a.getMember().getAge())
                        .gender(a.getMember().getGender())
                        .job(a.getMember().getJob())
                        .date(a.getCreatedAt())
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

        Member memberInSession = (Member) session.getAttribute("logined");
        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }




        return ResponseEntity.ok().body(
                articleService.fitterArticle(job, gender, category));


    }

    @DeleteMapping("/api/myarticle")
    public ResponseEntity<Object> deleteMyArticle(
            HttpSession session,
            @Param("article_id") Long article_id){

        Member memberInSession = (Member) session.getAttribute("logined");
        if (memberInSession == null) {
            return ResponseEntity.badRequest().body("로그인 하세요");
        }

        articleService.deleteArticle(memberInSession.getMember_id(), article_id);

        return ResponseEntity.ok().build();

    }




}
