package com.sprata.myblog.repository;

import com.sprata.myblog.entity.Comment;
import com.sprata.myblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUserId(Long Id);
    List<Comment> findAllByPostId(Long Id);
}
