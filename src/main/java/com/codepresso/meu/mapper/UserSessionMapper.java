package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.UserSession;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserSessionMapper {
    Integer save(@Param("userId") Integer userId);
    UserSession findOneById(@Param("sessionId") Integer id);
    void delete(Integer id);
}
