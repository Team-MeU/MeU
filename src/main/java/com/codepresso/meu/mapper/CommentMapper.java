package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findByCommentOfPostIdInPostPage(@Param("postId") Integer postId, @Param("limit") Integer limit, @Param("offset") Integer offset);
    List<Comment> findByCommentOfPostId(@Param("postId") Integer postId);
    Integer count(@Param("postId") Integer postId);


    Integer commentSave(@Param("comment") Comment comment);
    Integer commentUpdate(@Param("comment") Comment comment);
    Integer commentDelete(@Param("id") Integer id);
}
