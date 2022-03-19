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
    String content;
    Date createdAt;
    Date updatedAt;
    String imgUrl;
    User user;

    public Post(Integer postId, Integer userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public Post(Integer postId, Integer userId, String content, String userName, String nickName) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.user = new User(userName, nickName);
    }
}
