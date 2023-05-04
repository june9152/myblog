package com.sprata.myblog.controller;

import com.sprata.myblog.dto.PostRequestDto;
import com.sprata.myblog.dto.PostResponseDto;
import com.sprata.myblog.security.UserDetailsImpl;
import com.sprata.myblog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 관심 상품 등록하기
    @ResponseBody
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        PostResponseDto ret = postService.createPost(requestDto, userDetails.getUser());
        return ret;
    }

    // 게시물 조회하기
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts( @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        return postService.getPost( userDetails.getUser());
    }

    // 게시물 업데이트
    @PutMapping("/postsupdate/{id}")
    public PostResponseDto updateProduct(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기 (업데이트된 상품 id)

        return postService.updatePost(id,requestDto,  userDetails.getUser());
    }
    @DeleteMapping("/postsdelete/{id}")
    public PostResponseDto deleteProduct(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기 (업데이트된 상품 id)

        return postService.deletePost(id,requestDto,  userDetails.getUser());
    }
    @ResponseBody
    @PostMapping("/postlike/{id}")
    public PostResponseDto PostLike(@PathVariable Long id,@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        PostResponseDto ret = postService.PostLikeToggle(id,requestDto, userDetails.getUser());
        return ret;
    }


}
