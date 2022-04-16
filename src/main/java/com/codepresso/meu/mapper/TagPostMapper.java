package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Tag;
import com.codepresso.meu.vo.TagPostMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagPostMapper {

    Integer saveTagPost(@Param("tagId") Integer tagId, @Param("postId") Integer postId);
    Integer deleteTagPost(@Param("postId") Integer postId);
}
