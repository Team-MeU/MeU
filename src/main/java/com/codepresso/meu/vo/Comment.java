package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class Comment {
    Integer commentId;
    Integer userId;
    Integer postUserId;
    Integer postId;
    String content;
    Date updatedAt;
    Date createdAt;
    String nickname;
    String profileImg;

    public Comment(Integer commentId, Integer postId, Integer userId, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public Comment(Integer commentId, Integer postId, Integer userId, Integer postUserId, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.postUserId = postUserId;
        this.content = content;
    }


    public Comment(Integer commentId, Integer postId, Integer userId, String content, Date createdAt, Date updatedAt, String nickname, String profileImg) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nickname = nickname;
        this.profileImg = profileImg;

    }

}
