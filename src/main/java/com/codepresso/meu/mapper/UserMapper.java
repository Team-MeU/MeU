package com.codepresso.meu.mapper;

import com.codepresso.meu.controller.dto.FollowDto;
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
    boolean checkFollow(@Param("userId") Integer userId, @Param("followId") Integer followId);
    Integer getFollowingsNum(@Param("userId") Integer userId);
    Integer getFollowersNum(@Param("userId") Integer userId);
    List<Integer> getFollowersUserId(@Param("userId") Integer userId);
    List<Integer> getFollowingsUserId(@Param("userId") Integer userId);
    List<User> getFollowingUsers(@Param("userId") Integer userId);
    List<User> getFollowerUsers(@Param("userId") Integer userId);
}
