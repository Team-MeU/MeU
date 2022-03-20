package com.codepresso.meu.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class UserPageController {

    @RequestMapping("/user/signup")
    public String getSignupPage() {
        return "signup";
    }

    @RequestMapping("/user/login")
    public String getLoginPage() {
        return "login";
    }
}
