package com.sprata.myblog.dto;

import com.sprata.myblog.entity.Comment;
import com.sprata.myblog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String content;
    private String firstdate;
    private String lastdate;
    private String  writer;
    private Long delete;
    private Long postId;

    public CommentResponseDto(Comment post) {
        this.content = post.getContent();
        this.writer = post.getWriter();
        this.firstdate = post.getFirstdate();
        this.lastdate = post.getLastdate();
        this.delete = post.getDelete();
        this.postId = post.getPostId();

    }
}
