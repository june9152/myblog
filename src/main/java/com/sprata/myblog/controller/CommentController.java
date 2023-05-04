package com.sprata.myblog.controller;

import com.sprata.myblog.dto.CommentRequestDto;
import com.sprata.myblog.dto.CommentResponseDto;
import com.sprata.myblog.dto.PostRequestDto;
import com.sprata.myblog.dto.PostResponseDto;
import com.sprata.myblog.entity.Post;
import com.sprata.myblog.entity.User;
import com.sprata.myblog.security.UserDetailsImpl;
import com.sprata.myblog.service.CommentService;
import com.sprata.myblog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 관심 상품 등록하기
    @ResponseBody
    @PostMapping("/Comments/{id}")
    public CommentResponseDto createPost(@PathVariable Long id,@RequestBody CommentRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        CommentResponseDto ret = commentService.createComment(id,requestDto, userDetails.getUser());
        return ret;
    }

    // 게시물 조회하기
    @GetMapping("/Comments/{id}")
    public List<CommentResponseDto> getComments( @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        return commentService.getComment(userDetails.getUser());
    }

    // 관심 상품 최저가 등록하기
    @PutMapping("/Commentsupdate/{id}")
    public CommentResponseDto updateProduct(@PathVariable Long id, @RequestBody CommentRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기 (업데이트된 상품 id)

        return commentService.updateComment(id,requestDto, userDetails.getUser());
    }
    @DeleteMapping("/Commentsdelete/{id}")
    public CommentResponseDto deleteProduct(@PathVariable Long id, @RequestBody CommentRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기 (업데이트된 상품 id)

        return commentService.deleteComment(id,requestDto, userDetails.getUser());
    }
    @ResponseBody
    @PostMapping("/Commentslike/{id}")
    public CommentResponseDto CommentLike(@PathVariable Long id,@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        CommentResponseDto ret = commentService.CommentLikeToggle(id,requestDto, userDetails.getUser());
        return ret;
    }

}
