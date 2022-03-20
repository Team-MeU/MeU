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

    public CommentResponseDto(Integer post_id){
        this.postId = post_id;
    }

    public CommentResponseDto(Comment comment) {
        this.postId = comment.getPostId();
        this.commentInfoList.add(new CommentInfo(comment));
    }

    public void AddComment(Comment comment){
        this.commentInfoList.add(new CommentInfo(comment));
    }

}


