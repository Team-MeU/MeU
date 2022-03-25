package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Likes;

import java.util.Date;

public class LikesRequestDto {
    Integer likesId;
    Integer postId;
    Integer userId;
    Date createdAt;

    public Likes getLikes(){
        return new Likes(this.likesId, this.postId, this.userId, this.createdAt);
    }
}
