package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Post;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostRequestDto {
    Integer postId;
    Integer userId;
    String content;

    public Post getPost() {
        return new Post(this.postId, this.userId, this.content);
    }
}

