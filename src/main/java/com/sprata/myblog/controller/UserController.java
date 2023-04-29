package com.sprata.myblog.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
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

}
