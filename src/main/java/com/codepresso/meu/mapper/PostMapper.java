package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    List<Post> findByFeed(@Param("id") Integer id);
    Integer save(@Param("post") Post post);
    Integer update(@Param("post") Post post);
    Integer delete(@Param("id") Integer id);
}
