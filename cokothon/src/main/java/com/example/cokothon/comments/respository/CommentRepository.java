package com.example.cokothon.comments.respository;

import com.example.cokothon.comments.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
}
