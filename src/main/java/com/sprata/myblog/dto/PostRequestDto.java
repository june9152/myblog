package com.sprata.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Long id;
    // 제목
    private String title;
    // 게시글
    private String content;
    // 게시글
    private String password;
    // 작성자
    private String writer;
    // 작성일자
    private String firstdate;

    private String lastdate;

    private ArrayList<Long> likeUserId;

    private Long delete;
}
