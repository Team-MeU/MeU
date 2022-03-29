package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {

    Integer saveTag(@Param("tag") Tag tag);

}
