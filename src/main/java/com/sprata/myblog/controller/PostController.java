package com.sprata.myblog.controller;

import com.sprata.myblog.dto.PostRequestDto;
import com.sprata.myblog.dto.PostResponseDto;
import com.sprata.myblog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService productService;

    // 관심 상품 등록하기
    @ResponseBody
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기
        PostResponseDto ret = productService.createPost(requestDto, request);
        return ret;
    }

    // 게시물 조회하기
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(HttpServletRequest request) {
        // 응답 보내기
        return productService.getPost(request);
    }

    // 관심 상품 최저가 등록하기
    @PutMapping("/postsupdate/{id}")
    public PostResponseDto updateProduct(@PathVariable Long id, @RequestBody PostRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기 (업데이트된 상품 id)

        return productService.updatePost(id,requestDto, request);
    }
    @DeleteMapping("/postsdelete/{id}")
    public PostResponseDto deleteProduct(@PathVariable Long id, @RequestBody PostRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기 (업데이트된 상품 id)

        return productService.deletePost(id,requestDto, request);
    }


}
