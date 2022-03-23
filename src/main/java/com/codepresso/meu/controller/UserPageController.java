package com.codepresso.meu.controller;

import com.codepresso.meu.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/user/profile")
    public String getProfilePage(Model model) {
        //List<Post> myPost = postService.getMyPosts();
        return "profile";
    }

}
