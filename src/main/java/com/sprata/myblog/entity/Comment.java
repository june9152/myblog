package com.sprata.myblog.entity;

import com.sprata.myblog.dto.CommentRequestDto;
import com.sprata.myblog.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID가 자동으로 생성 및 증가합니다.
    private Long id;

    @Column(nullable = true)
    private String content;


    @Column(nullable = true)
    private String firstdate;

    @Column(nullable = true)
    private String lastdate;

    @Column(nullable = false)
    private String  writer;

    @Column(nullable = true)
    private Long delete;
    @Column(nullable = false)
    private Long postId;
    @Column(nullable = false)
    private Long userId;
    public Comment(CommentRequestDto requestDto, Long userId,Long postId) {
        this.content = requestDto.getContent();
        this.firstdate = requestDto.getFirstdate();
//        this.lastdate = lastdate;
        this.writer = requestDto.getWriter();
        this.userId = userId;
        this.postId = postId;
//        this.delete = requestDto.
    }

    public void Update(CommentRequestDto requestDto) {

        this.content = requestDto.getContent();
        this.firstdate = requestDto.getFirstdate();
    }
}
