package com.sprata.myblog.dto;

import com.sprata.myblog.entity.Post;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private String password;
    private String firstdate;
    private String lastdate;
    private String  writer;
    private Long delete;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.password = post.getPassword();
        this.writer = post.getWriter();
        this.firstdate = post.getFirstdate();
        this.lastdate = post.getLastdate();
        this.delete = post.getDelete();

    }
}
