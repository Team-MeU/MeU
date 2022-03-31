package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class Post {
    Integer postId;
    Integer userId;
    String postUserProfileImg;
    String content;
    Date createdAt;
    Date updatedAt;
    String imgUrl;
    User user;

    public Post(Integer postId, Integer userId, String content, String imgUrl) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public Post(Integer postId, Integer userId, String content, Date createdAt, String email, String nickname) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.user = new User(email, nickname);
    }

    public Post(Integer postId, Integer userId, String postUserProfileImg, String content, Date createdAt, String imgUrl, String email, String nickname) {
        this.postId = postId;
        this.userId = userId;
        this.postUserProfileImg = postUserProfileImg;
        this.content = content;
        this.createdAt = createdAt;
        this.imgUrl = imgUrl;
        this.user = new User(email, nickname);
    }

}
