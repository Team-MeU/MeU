package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentRequestDto;
import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.vo.Comment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // postId는 포스트 게시물에서 받고, commentId는 comment테이블 조회헤서 마지막
    @PostMapping("/comment")
    public String createComment(@RequestBody CommentRequestDto commentDto){
        Comment comment = commentDto.getComment();
        commentService.saveComment(comment);

        return "created comment is success";
    }

    @PutMapping("/comment")
    public String updateComment(@RequestBody CommentRequestDto commentDto){
        Comment comment = commentDto.getComment();
        commentService.updateComment(comment);

        return "update comment is success";
    }

    @DeleteMapping("/comment")
    public String deleteComment(@RequestParam Integer commentId) {
        commentService.deleteComment(commentId);

        return "delete comment success";
    }
}
