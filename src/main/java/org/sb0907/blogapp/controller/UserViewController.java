package org.sb0907.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    // 로그인화면으로 이동
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // 회원가입 화면으로 이동
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
