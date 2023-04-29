package com.sprata.myblog.service;



import com.sprata.myblog.dto.PostRequestDto;
import com.sprata.myblog.dto.PostResponseDto;
import com.sprata.myblog.repository.PostRepository;
import com.sprata.myblog.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

//
    private final PostRepository productRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpServletRequest request) {
        return null;
    }
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPost(HttpServletRequest request) {
        return null;
    }
}
