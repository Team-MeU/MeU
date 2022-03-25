package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Post;
import lombok.Getter;

import java.util.Date;

@Getter
public class PostResponseDto {
    Integer postId;
    Integer userId;
    String content;
    Date createdAt;
    String imgUrl;
    String email;
    String nickname;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.imgUrl = post.getImgUrl();
        this.email = post.getUser().getEmail();
        this.nickname = post.getUser().getNickname();
    }
}
