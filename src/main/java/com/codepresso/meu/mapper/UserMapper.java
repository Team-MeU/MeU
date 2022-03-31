package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserbyId(@Param("id") int id);
    Integer save(@Param("user") User user);
    User findOneByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    Integer modify(@Param("user") User user);
}
