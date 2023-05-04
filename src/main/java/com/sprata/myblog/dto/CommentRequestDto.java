package com.sprata.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private String firstdate;
    private String lastdate;
    private String  writer;
    private Long delete;
    private List<Long> likeUserId;
}
