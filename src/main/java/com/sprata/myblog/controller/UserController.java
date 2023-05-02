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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
//    private final UserService userService;
    // 게시물 조회하기
//    @GetMapping("/writer")
//    public ModelAndView writerPage(HttpServletRequest request) {
//        return new ModelAndView("writer");
//    }
//    @GetMapping("/login")
//    public ModelAndView loginPage(HttpServletRequest request) {
//        return new ModelAndView("login");
//    }
//    @GetMapping("/signup")
//    public ModelAndView signupPage(HttpServletRequest request) {
//        return new ModelAndView("signup");
//    }

//    @PostMapping("/signup")
//    public String signup(SignupRequestDto signupRequestDto) {
//
//        userService.signup(signupRequestDto);
//        return "redirect:/api/user/login";
//    }
//    @ResponseBody
//    @PostMapping("/signup")
//    public BlogResponseDto signup(@RequestBody  SignupRequestDto signupRequestDto) {
//        BlogResponseDto ret =userService.signup(signupRequestDto);
//        return ret;
//    }
//
//    @ResponseBody
//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
//        userService.login(loginRequestDto, response);
//        return "success";
//    }


    private final UserService userService;
//    private  final KakaoService kakaoService;
    @GetMapping("/signup")
    public ModelAndView signupPage() {
        return new ModelAndView("signup");
    }

    @GetMapping("/login-page")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login-page";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }

    @GetMapping("/index")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }
    @GetMapping("/forbidden")
    public ModelAndView getForbidden() {
        return new ModelAndView("forbidden");
    }

    @PostMapping("/forbidden")
    public ModelAndView postForbidden() {
        return new ModelAndView("forbidden");
    }
    @ResponseBody
    @GetMapping("/loginGet")
    public String loginGet(HttpServletResponse response) {
        return userService.loginGet(response) == true ? "success":"fail";
    }


}
