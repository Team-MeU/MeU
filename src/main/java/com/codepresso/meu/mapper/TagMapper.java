package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Tag;
import com.codepresso.meu.vo.TagPostMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    Tag findTagByContent(@Param("content") String content);
    Integer saveTag(@Param("content") String content);
    Integer countTag(@Param("tagId") Integer tagId);
    Integer addTagCount(@Param("tagId") Integer tagId);
    List<Tag> findByTagCount();
}
