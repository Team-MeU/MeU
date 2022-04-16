package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class DeletePost {
    Integer deletePostId;
    Integer userId;
    Integer postId;
    String content;
    Date createdAt;
    Date updatedAt;
    Date deletedAt;
}
