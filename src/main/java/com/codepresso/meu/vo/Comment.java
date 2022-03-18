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
    Integer postId;
    String content;
    Date updatedAt;
    Date createdAt;
}
