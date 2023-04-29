package com.sprata.myblog.repository;

import com.sprata.myblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findAllByUserId(Long userId);
//    Optional<Post> findByIdAndUserId(Long id, Long userId);
}
