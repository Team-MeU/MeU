package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserbyId(@Param("id") int id);
    Integer save(@Param("user") User user);
    User findOneByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    Integer modify(@Param("user") User user);
    List<User> getAllUsers();
    Integer getUserIdByNickname(@Param("nickname") String nickname);
    Integer followUser(@Param("userId") Integer userId, @Param("followId") Integer followId);
    Integer unfollowUser(@Param("userId") Integer userId, @Param("followId") Integer followId);
}
