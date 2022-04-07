package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.FeedRequestDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.service.TrendingService;
import com.codepresso.meu.service.TagService;
import com.codepresso.meu.service.UserService;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private PostService postService;
    private CommentService commentService;
    private UserService userService;
    private TagService tagService;
    private TrendingService trendingService;
    private UserSessionService userSessionService;
    
    public IndexController(PostService postService, CommentService commentService, UserService userService, TagService tagService, 
                           TrendingService trendingService, UserSessionService userSessionService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
        this.tagService = tagService;
        this.trendingService = trendingService;
        this.userSessionService = userSessionService;
    }

    @RequestMapping(value= "/")
    public String index(Model model, @RequestBody(required = false) FeedRequestDto feedDto,
                        @CookieValue(value = "page",required = false) String currentPage, HttpServletResponse response,
                        HttpServletRequest request, @CookieValue(name="id", required = false) Integer sessionId) {

        List<FeedItem> feedItems = new ArrayList<>();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
      
        boolean isFinalPage = false;
        if (feedDto == null) {
            feedDto = new FeedRequestDto(1,0);
        }

        if(currentPage == null) {
            currentPage = "1";
            Cookie cookie = new Cookie("page", currentPage);
            cookie.setMaxAge(60 * 60 * 24);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        List<User> users = userService.getAllUsers(); //전체 사용자 조회 및 팔로우 추천
        Integer maxSearchPostCnt;

        if(sessionId==null) { // no login
            maxSearchPostCnt = postService.getAllPost().size();

            if(postService.getViewPostSize() * Integer.parseInt(currentPage) > maxSearchPostCnt) {
                isFinalPage = true;
            }

            postList = postService.getPostByPage(Integer.parseInt(currentPage));
            for(Post post : postList) {
                postResponseDtos.add(new PostResponseDto(post));
                List<Comment> commentList = commentService.getCommentListByPostInFeed(post.getPostId(), 1);
                FeedItem feeditem = new FeedItem(new PostResponseDto(post), commentList);
                feeditem.setLikeCnt(postService.getLikesOfPost(post.getPostId()).size());
                feeditem.setCommentCnt(commentService.getCommentsOfPost(post.getPostId()));
                feedItems.add(feeditem);
            }

        }
        else { //login
            UserSession userSession = userSessionService.getUserSessionById(sessionId);
            for(User u : users) { //팔로우 목록에서 본인 제외
                if(u.getUserId() == userSession.getUserId()) {
                    users.remove(u);
                    break;
                }
            }
            maxSearchPostCnt = postService.getFeed(userSession.getUserId()).size();

            if(postService.getViewPostSize() * Integer.parseInt(currentPage) > maxSearchPostCnt) {
                isFinalPage = true;
            }

            postList = postService.getFeedByPage(userSession.getUserId(), Integer.parseInt(currentPage));
            for(Post post : postList) {
                postResponseDtos.add(new PostResponseDto(post));
                List<Comment> commentList = commentService.getCommentListByPostInFeed(post.getPostId(), 1);
                FeedItem feeditem = new FeedItem(new PostResponseDto(post), commentList);
                feeditem.setLikeCnt(postService.getLikesOfPost(post.getPostId()).size());
                feeditem.setCommentCnt(commentService.getCommentsOfPost(post.getPostId()));
                feedItems.add(feeditem);
            }
        }

        model.addAttribute("isFinalPage", isFinalPage);
        model.addAttribute("feedItems", feedItems);
        model.addAttribute("users", users);

        return "index";
    }

    // Trending Page
    @RequestMapping(value = "/trending")
    public String getTrendingPage(Model model, @CookieValue(value = "page",required = false) String trendCurrentPage, HttpServletResponse response) {
        boolean isFinalPage = false;
        List<FeedItem> trendingItems = new ArrayList<>();
        List<PostResponseDto> trendingResponseDtos = new ArrayList<>();
        List<Post> trendingList = new ArrayList<>();
        trendingList = trendingService.getTrendingPage();
        Integer maxPostCnt = 30;


        for(Post trend : trendingList) {
            trendingResponseDtos.add(new PostResponseDto(trend));
            List<Comment> commentList = commentService.getCommentListByPostInFeed(trend.getPostId(), 1);
            FeedItem trenditem = new FeedItem(new PostResponseDto(trend), commentList);
            trenditem.setLikeCnt(postService.getLikesOfPost(trend.getPostId()).size());
            trenditem.setCommentCnt(commentService.getCommentsOfPost(trend.getPostId()));
            trendingItems.add(trenditem);
        }

        model.addAttribute("trendingItems",trendingItems);
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return "trending";
    }

    // Explore Page
    @RequestMapping(value = "/explore")
    public String getExplorePage(Model model) {
        List<Tag> tagList = tagService.findByTagCount();
        model.addAttribute("tagList", tagList);
        return "explore";
    }

    // Fag Page
    @RequestMapping(value = "/faq")
    public String getFaqPage() {
        return "faq";
    }

    // Contact Page
    @RequestMapping(value = "/contact")
    public String getContactPage() {
        return "contact";
    }

    // 404 Page
    @RequestMapping(value = "/404")
    public String get404Page() {
        return "404";
    }

}
