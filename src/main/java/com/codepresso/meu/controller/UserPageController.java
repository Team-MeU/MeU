package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.service.UserService;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserPageController {
    private PostService postService;
    private UserSessionService userSessionService;
    private UserService userService;
    private CommentService commentService;

    @RequestMapping("/user/signup")
    public String getSignupPage() {
        return "signup";
    }

    @RequestMapping("/user/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping("/profile")
    public String getProfilePage(Model model, @CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId == null){
            System.out.println("No Cookie!");
            return "login";
        }

        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession==null) {
            System.out.println("login first!!");
            return "login";
        }

        User user = userService.getUserbyId(userSession.getUserId());
        List<Post> myPost = postService.getMyPosts(userSession.getUserId());
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        //List<Comment> commentList = new ArrayList<>();
        List<FeedItem> feedItems = new ArrayList<>();

        for(Post post : myPost) {
            postResponseDtos.add(new PostResponseDto(post));
            List<Comment> commentList = commentService.getCommentListByPostInFeed(post.getPostId(), 1);
            FeedItem feeditem = new FeedItem(new PostResponseDto(post), commentList);
            feedItems.add(feeditem);
        }
        model.addAttribute("user",user);
        model.addAttribute("feedItems", feedItems);
        return "profile";
    }

    @RequestMapping("/edit-profile")
    public String editProfilePage(Model model, @CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId==null){
            System.out.println("No Cookie!");
            return "login";
        }

        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession==null) {
            System.out.println("login first!!");
            return "login";
        }

        User user = userService.getUserbyId(userSession.getUserId());
        model.addAttribute("user", user);

        return "edit-profile";
    }

    @RequestMapping("/checkpwd")
    public String checkPwd(@CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId==null){
            System.out.println("No Cookie!");
            return "login";
        }
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession==null) {
            System.out.println("login first!!");
            return "login";
        }

        return "check-password";
    }


}
