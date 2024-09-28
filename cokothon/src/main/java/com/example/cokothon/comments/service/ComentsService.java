package com.example.cokothon.comments.service;

import com.example.cokothon.article.entity.Article;
import com.example.cokothon.article.repository.ArticleRepository;
import com.example.cokothon.comments.domain.Comments;
import com.example.cokothon.comments.dto.AddComments;
import com.example.cokothon.comments.respository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComentsService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public Long addComments(AddComments addComments) {

        Comments comments =  Comments.builder()
                        .content(addComments.getContent())
                                .writerId(addComments.getWriter_id())
                                        .build();

        Optional<Article> article =  articleRepository.findById(addComments.getArticle_id());

        article.get().changeComments(comments);

        return commentRepository.save(comments).getId();
    }
}
