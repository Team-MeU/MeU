package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    Integer commentId;
    Integer postId;
    Integer userId;
    String content;
    String nickname;
    String profileImg;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPostId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.nickname = comment.getNickname();
        this.profileImg = comment.getProfileImg();
    }
}
