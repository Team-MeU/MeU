package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Comment;
import lombok.Getter;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentResponseDto {
    Integer postId;
    List<CommentInfo> commentInfoList = new ArrayList<>();

    public CommentResponseDto(Comment comment) {
        this.postId = comment.getPostId();
        CommentInfo commentInfo = new CommentInfo(comment);
        this.commentInfoList.add(commentInfo);
    }
}


