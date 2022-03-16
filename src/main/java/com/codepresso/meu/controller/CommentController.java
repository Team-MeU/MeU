package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.vo.Comment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class CommentController {
    private CommentService commentService;

    @GetMapping("/comment")
    public List<CommentResponseDto> getCommentListByPost(@RequestParam("postId") Integer postId){
        List<Comment> comments = commentService.getCommentListByPostInFeed(postId);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for(Comment comment : comments){
            commentResponseDtos.add(new CommentResponseDto(comment));
        }
        return commentResponseDtos;
    }
}
