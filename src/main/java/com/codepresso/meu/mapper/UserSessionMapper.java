package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.UserSession;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserSessionMapper {
    void save(@Param("userSession") UserSession userSession);
    UserSession findOneById(@Param("sessionId") Integer id);
    Integer findIdByUser(@Param("userId") Integer id);
    boolean existUser(@Param("userId") Integer userId);
    void updateSession(@Param("userId") Integer userId);
    void delete(Integer id);
}
