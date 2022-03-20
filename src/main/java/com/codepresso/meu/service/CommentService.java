package com.codepresso.meu.service;

import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.mapper.CommentMapper;
import com.codepresso.meu.vo.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentMapper commentMapper;

    public List<Comment> getCommentListByPostInFeed(Integer postId){
        List<Comment> commentList = commentMapper.findByCommentOfPostId(postId);

        if (commentList == null) return new ArrayList<Comment>();
        if(commentList.isEmpty()) return new ArrayList<Comment>();
        return commentList;
    }

    //public List<Comment> getCommentListByPostInPostPage(Integer postId, Integer page, Integer size){
      //  return commentMapper.findByCommentOfPostIdInPostPage(postId, page, size);
    //}

    public boolean saveComment(Comment comment){
        Integer result = commentMapper.commentSave(comment);
        return result == 1;
    }

    public boolean updateComment(Comment comment) {
        Integer result = commentMapper.commentUpdate(comment);
        return result == 1;
    }

    public boolean deleteComment(Integer commentId) {
        Integer result = commentMapper.commentDelete(commentId);
        return result == 1;
    }


}
