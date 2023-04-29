package com.sprata.myblog.controller;

import com.sprata.myblog.dto.LoginRequestDto;
import com.sprata.myblog.dto.SignupRequestDto;
import com.sprata.myblog.dto.BlogResponseDto;
import com.sprata.myblog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    // 게시물 조회하기
    @GetMapping("/writer")
    public ModelAndView writerPage(HttpServletRequest request) {
        return new ModelAndView("writer");
    }
    @GetMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request) {
        return new ModelAndView("login");
    }
    @GetMapping("/signup")
    public ModelAndView signupPage(HttpServletRequest request) {
        return new ModelAndView("signup");
    }

//    @PostMapping("/signup")
//    public String signup(SignupRequestDto signupRequestDto) {
//
//        userService.signup(signupRequestDto);
//        return "redirect:/api/user/login";
//    }

    @PostMapping("/signup")
    public BlogResponseDto signup(SignupRequestDto signupRequestDto) {
        BlogResponseDto ret =userService.signup(signupRequestDto);
        return ret;
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }
    @ResponseBody
    @GetMapping("/loginGet")
    public String loginGet(HttpServletResponse response) {
        return userService.loginGet(response) == true ? "success":"fail";
    }


}
