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
import org.springframework.web.bind.annotation.PathVariable;
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

    // 로그인한 사용자 프로필
    @RequestMapping("/myprofile")
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
            feeditem.setLikeCnt(postService.getLikesOfPost(post.getPostId()).size());
            feeditem.setCommentCnt(commentService.getCommentsOfPost(post.getPostId()));
            feedItems.add(feeditem);
        }
        model.addAttribute("user",user);
        model.addAttribute("feedItems", feedItems);

        // 팔로우 정보
        Integer followingsCount = userService.getFollowingsCount(userSession.getUserId());
        Integer followersCount = userService.getFollowersCount(userSession.getUserId());
        model.addAttribute("followingsCount", followingsCount);
        model.addAttribute("followersCount", followersCount);
        return "profile";
    }

    // 다른 사용자 프로필
    @RequestMapping("/profile/{nickname}")
    public String getProfilePage(@PathVariable("nickname") String nickname, Model model) {
        Integer userId = userService.getUserIdByNickname(nickname);
        User user = userService.getUserbyId(userId);

        List<Post> myPost = postService.getMyPosts(userId);
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<FeedItem> feedItems = new ArrayList<>();

        for(Post post : myPost) {
            postResponseDtos.add(new PostResponseDto(post));
            List<Comment> commentList = commentService.getCommentListByPostInFeed(post.getPostId(), 1);
            FeedItem feeditem = new FeedItem(new PostResponseDto(post), commentList);
            feeditem.setLikeCnt(postService.getLikesOfPost(post.getPostId()).size());
            feeditem.setCommentCnt(commentService.getCommentsOfPost(post.getPostId()));
            feedItems.add(feeditem);

        }
        model.addAttribute("user", user);
        model.addAttribute("feedItems", feedItems);

        // 팔로우 정보
        Integer followingsCount = userService.getFollowingsCount(userId);
        Integer followersCount = userService.getFollowersCount(userId);
        model.addAttribute("followingsCount", followingsCount);
        model.addAttribute("followersCount", followersCount);
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

    @RequestMapping("/following")
    public String followingPage(Model model, @CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId==null){
            System.out.println("No Cookie!");
            return "login";
        }
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession==null) {
            System.out.println("login first!!");
            return "login";
        }
        List<User> followings = userService.getFollowingUsers(userSession.getUserId());
        model.addAttribute("followings", followings);
        return "following";
    }

    @RequestMapping("/follower")
    public String followerPage(Model model, @CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId==null){
            System.out.println("No Cookie!");
            return "login";
        }
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession==null) {
            System.out.println("login first!!");
            return "login";
        }
        List<User> followers = userService.getFollowerUsers(userSession.getUserId());
        model.addAttribute("followers", followers);
        return "follower";
    }
}
