package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Comment;
import lombok.Setter;

@Setter
public class CommentRequestDto {
    Integer commentId;
    Integer postId;
    Integer userId;
    String content;

    public Comment getComment() {
        return new Comment(this.commentId, this.postId, this.userId, this.content);
    }
}