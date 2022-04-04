package com.codepresso.meu.service;

import com.codepresso.meu.controller.dto.FollowDto;
import com.codepresso.meu.mapper.UserMapper;
import com.codepresso.meu.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {
    private UserMapper userMapper;
    private UserSessionService userSessionService;

    public User getUserbyId(int id) {
        return userMapper.getUserbyId(id);
    }

    public void saveUser(User user) {
        userMapper.save(user);
    }

    public Integer loginUser(User user) {
        User userResult = getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        Integer sessionId = userSessionService.saveUserSession(userResult.getUserId());
        return sessionId;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = userMapper.findOneByEmailAndPassword(email, password);
        if(user == null) {
            throw new NoSuchElementException();
        }
        return user;
    }

    public void modifyUser(User user) {
        userMapper.modify(user);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public Integer getUserIdByNickname(String nickname) {
        return userMapper.getUserIdByNickname(nickname);
    }

    public void followUser(Integer userId, Integer followId) {
        userMapper.followUser(userId, followId);
    }

    public void unfollowUser(Integer userId, Integer followId) {
        userMapper.unfollowUser(userId, followId);
    }

    public boolean checkFollow(Integer userId, Integer followId) {
        return userMapper.checkFollow(userId, followId);
    }

    public Integer getFollowingsCount(Integer userId) {
        return userMapper.getFollowings(userId);
    }

    public Integer getFollowersCount(Integer userId) {
        return userMapper.getFollowers(userId);
    }
}
