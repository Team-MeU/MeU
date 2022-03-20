package com.codepresso.meu.service;

import com.codepresso.meu.mapper.UserSessionMapper;
import com.codepresso.meu.vo.UserSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSessionService {
    private UserSessionMapper userSessionMapper;

    public UserSession getUserSessionById(Integer id) {
        return userSessionMapper.findOneById(id);
    }

    public Integer saveUserSession(Integer userId) {
        //UserSession userSession = new UserSession(userId);
        //System.out.println("userSession.getUserId() = " + userSession.getUserId());
        Integer sessionId = userSessionMapper.save(userId);
        return sessionId;
    }

    public void deleteUserSession(Integer id) {
        userSessionMapper.delete(id);
    }
}
