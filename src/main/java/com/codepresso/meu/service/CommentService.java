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

    public List<Comment> getCommentListByPostInFeed(Integer postId, Integer page){
        List<Comment> commentList = commentMapper.findByCommentOfPostId(postId, page, 3);

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


    public boolean updateComment(Comment comment, Integer logInUserId) {
        Comment originalComment = commentMapper.commentFindOne(comment.getCommentId());
        if(!originalComment.getUserId().equals(logInUserId)) {
            return false;
        }
        Integer result = commentMapper.commentUpdate(comment);
        return result == 1;
    }

    public boolean deleteComment(Integer commentId, Integer logInUserId) {
        Comment originalComment = commentMapper.commentFindOne(commentId);
        if(!originalComment.getUserId().equals(logInUserId)) {
            return false;
        }
        Integer result = commentMapper.commentDelete(commentId);
        return result == 1;
    }


}