package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    Integer commentId;
    Integer userId;
    Integer postId;
    String content;

    public Comment getComment() {
        return new Comment(this.commentId, this.postId, this.userId, this.content);
    }
}