package com.codepresso.meu.service;

import com.codepresso.meu.mapper.UserMapper;
import com.codepresso.meu.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


}
