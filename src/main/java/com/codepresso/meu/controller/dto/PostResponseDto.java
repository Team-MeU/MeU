package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    Integer postId;
    Integer userId;
    String content;
    String userName;
    String nickName;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.content = post.getContent();
        this.userName = post.getUser().getUserName();
        this.nickName = post.getUser().getNickname();
    }
}
