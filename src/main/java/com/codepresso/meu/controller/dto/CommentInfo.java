package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentInfo {
    Integer commentId;
    Integer userId;
    String commentContent;
    String commentNickname;
    String profileImg;

    public CommentInfo(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentContent = comment.getContent();
        this.userId = comment.getUserId();
        this.commentNickname = comment.getNickname();
        this.profileImg = comment.getProfileImg();
    }
}
