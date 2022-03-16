package com.codepresso.meu.service;

import com.codepresso.meu.mapper.CommentMapper;
import com.codepresso.meu.vo.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentMapper commentMapper;

    public List<Comment> getCommentListByPostInFeed(Integer postId){
        return commentMapper.findByCommentOfPostIdInFeed(postId);
    }

    public List<Comment> getCommentListByPostInPostPage(Integer postId, Integer page, Integer size){
        return commentMapper.findByCommentOfPostIdInPostPage(postId, page, size);
    }

    public boolean saveComment(Comment comment){
        Integer result = commentMapper.save(comment);
        return result == 1;
    }

    public boolean updateComment(Comment comment) {
        Integer result = commentMapper.update(comment);
        return result == 1;
    }

    public boolean deleteComment(Integer id) {
        Integer result = commentMapper.delete(id);
        return result == 1;
    }


}
