package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.vo.Comment;
import com.codepresso.meu.vo.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    private PostService postService;
    private CommentService commentService;

    public IndexController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }
    @RequestMapping(value="/")
    public List<List<CommentResponseDto>> index(Model model) {
        List<Post> postList = postService.getAllPost();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        List<List<CommentResponseDto>> CommentResponseDtosByPostId = new ArrayList<List<CommentResponseDto>>();

        for(Post post : postList) {
            int postId = post.getPostId();
            postResponseDtos.add(new PostResponseDto(post));

            List<Comment> commentList = commentService.getCommentListByPostInFeed(postId);
            List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
            for(Comment comment : commentList){
                commentResponseDtos.add(new CommentResponseDto(comment));
            }
            CommentResponseDtosByPostId.add(commentResponseDtos);
        }
        System.out.println(CommentResponseDtosByPostId);
        model.addAttribute("posts", postResponseDtos);
        model.addAttribute("comments",CommentResponseDtosByPostId);
        return CommentResponseDtosByPostId;
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