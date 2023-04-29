package com.sprata.myblog.dto;

import com.sprata.myblog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.password = post.getPassword();
        this.writer = post.getWriter();
        this.writeDate = post.getWriter();
    }
}
