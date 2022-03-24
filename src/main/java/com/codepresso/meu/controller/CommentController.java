package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CommentInfo;
import com.codepresso.meu.controller.dto.CommentRequestDto;
import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.service.CommentService;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.Comment;
import com.codepresso.meu.vo.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class CommentController {
    private CommentService commentService;
    private UserSessionService userSessionService;


    @GetMapping("/comment")
    public List<CommentInfo> getCommentListByPage(@RequestParam("postId") Integer postId, @RequestParam("page") Integer page){
        List<Comment> comments = commentService.getCommentListByPostInPostPage(postId, page);
        List<CommentInfo> pageCommentDtos = new ArrayList<>();
        for(Comment comment : comments) {
            pageCommentDtos.add(new CommentInfo(comment));
        }
        return pageCommentDtos;
    }

    @PostMapping("/comment")
    public ResponseEntity<String> createComment(@RequestBody CommentRequestDto commentDto, @CookieValue("id") Integer sessionId){
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        Integer logInUserId = userSession.getUserId();
        Comment comment = commentDto.getComment();
        comment.setUserId(logInUserId);
        commentService.saveComment(comment);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @PutMapping("/comment")
    public ResponseEntity<String> updateComment(@RequestBody CommentRequestDto commentDto, @CookieValue("id") Integer sessionId) {
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        Integer logInUserId = userSession.getUserId();

        Comment comment = commentDto.getComment();
        Boolean result = commentService.updateComment(comment, logInUserId);

        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
    }

    @DeleteMapping("/comment")
    public ResponseEntity deleteComment(@RequestParam Integer commentId, @CookieValue("id") Integer sessionId) {
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        Integer logInUserId = userSession.getUserId();
        Boolean result = commentService.deleteComment(commentId, logInUserId);

        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
    }
}
