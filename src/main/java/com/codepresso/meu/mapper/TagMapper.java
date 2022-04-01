package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    Tag findTag(@Param("content") String content);
    Integer saveTag(@Param("tag") Tag tag);

}
