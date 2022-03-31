package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.vo.Comment;
import com.codepresso.meu.vo.FeedItem;
import com.codepresso.meu.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private PostService postService;
    private CommentService commentService;

    public IndexController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @RequestMapping(value="/")
    public String index(Model model) {
        List<Post> postList = postService.getAllPost();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<FeedItem> feedItems = new ArrayList<>();

        for(Post post : postList) {
            postResponseDtos.add(new PostResponseDto(post));
            List<Comment> commentList = commentService.getCommentListByPostInFeed(post.getPostId(), 1);
            FeedItem feeditem = new FeedItem(new PostResponseDto(post), commentList);
            feeditem.setLikeCnt(postService.getLikesOfPost(post.getPostId()).size());
            feeditem.setCommentCnt(postService.getLikesOfPost(post.getPostId()).size());
            feedItems.add(feeditem);
        }

        model.addAttribute("feedItems", feedItems);
        return "index";
    }

    // Trending Page
    @RequestMapping(value = "/trending")
    public String getTrendingPage() {
        return "tags";
    }

    // Explore Page
    @RequestMapping(value = "/explore")
    public String getExplorePage() {
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



}
//if(postByComment.isEmpty()) continue;
//System.out.println("///////////"+postByComment+"/////////////");
//if(!(postByComment.isEmpty())) {
//   for (Comment comment : postByComment) {
//      postComment.add(new CommentResponseDto(comment));
// }
// commentResponseDtos.add(postComment);
// }