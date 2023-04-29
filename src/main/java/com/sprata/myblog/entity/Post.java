package com.sprata.myblog.entity;

import com.sprata.myblog.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID가 자동으로 생성 및 증가합니다.
    private Long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String content;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String firstdate;

    @Column(nullable = true)
    private String lastdate;

    @Column(nullable = false)
    private String  writer;
    @Column(nullable = true)
    private Long delete;
    @Column(nullable = false)
    private Long userId;
    public Post(PostRequestDto requestDto,Long userId) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.firstdate = requestDto.getFirstdate();

//        this.lastdate = lastdate;
        this.writer = requestDto.getWriter();
        this.userId = userId;
//        this.delete = requestDto.
    }

    public void Update(PostRequestDto requestDto) {

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.firstdate = requestDto.getFirstdate();
    }

}
