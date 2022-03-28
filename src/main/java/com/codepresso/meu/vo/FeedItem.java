package com.codepresso.meu.vo;

import com.codepresso.meu.controller.dto.CommentInfo;
import com.codepresso.meu.controller.dto.CommentResponseDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FeedItem {
    Integer postId;
    Integer userId;
    String postUserProfileImg;
    String content;
    Date createdAt;
    Date updatedAt;
    String imgUrl;
    String email;
    String nickname;
    Integer likeCnt;
    Integer commentCnt;
    List<Comment> commentListByPost = new ArrayList<>();

    public FeedItem(PostResponseDto post, List<Comment> commentList){
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.content = post.getContent();
        this.postUserProfileImg = post.getPostUserProfileImg();
        this.createdAt = post.getCreatedAt();
        this.imgUrl = post.getImgUrl();
        this.email = post.getEmail();
        this.nickname = post.getNickname();
        this.commentListByPost = commentList;
    }


}
