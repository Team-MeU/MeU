package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.vo.Comment;
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
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        for(Post post : postList) {
            int postId = post.getPostId();
            postResponseDtos.add(new PostResponseDto(post));
            List<Comment> commentList = commentService.getCommentListByPostInFeed(postId);
            CommentResponseDto commentResponseDto = new CommentResponseDto(postId);

            for(Comment comment : commentList){
                commentResponseDto.AddComment(comment);
            }
            commentResponseDtos.add(commentResponseDto);
        }
        model.addAttribute("posts", postResponseDtos);
        model.addAttribute("comments",commentResponseDtos);
        return "index";
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