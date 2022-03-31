package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class Likes {
    Integer likesId;
    Integer postId;
    Integer userId;
    Date createdAt;


    public Likes(Integer postId, Integer userId){
        this.userId = userId;
        this.postId = postId;
    }
}



