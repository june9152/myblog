package com.sprata.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor  // 파라미터가 있는 생성자 자동 생성
public class BlogResponseDto {
    private final int statusCode;
    private String msg;

    public static BlogResponseDto signupSuccess()
    {
        return new BlogResponseDto(200,"singup success");
    }

    public static BlogResponseDto loginSuccess()
    {
        return new BlogResponseDto(200,"login success");
    }

    public static BlogResponseDto delSuccess()
    {
        return new BlogResponseDto(200,"del success");
    }
    public static BlogResponseDto updateSuccess()
    {
        return new BlogResponseDto(200,"update success");
    }

}
