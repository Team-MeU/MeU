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
}
