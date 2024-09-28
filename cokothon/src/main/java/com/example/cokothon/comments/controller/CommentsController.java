package com.example.cokothon.comments.controller;

import com.example.cokothon.comments.dto.AddComments;
import com.example.cokothon.comments.service.ComentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final ComentsService commentsService;

    @PostMapping("/api/comment")
    public ResponseEntity<Object> postComment(@RequestBody AddComments addComments) {
            commentsService.addComments(addComments);

            return ResponseEntity.ok().build();
    }

}
