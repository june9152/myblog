package com.sprata.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    // 제목
    private String title;
    // 게시글
    private String content;
    // 게시글
    private String password;
    // 작성자
    private String writer;
    // 작성자
    private String writeDate;

}
