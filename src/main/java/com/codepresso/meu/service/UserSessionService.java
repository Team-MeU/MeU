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
        //존재 확인
        if(userSessionMapper.existUser(userId)) {
            //기존 세션 updateAt만 변경
            userSessionMapper.updateSession(userId);

        } else {
            UserSession userSession = new UserSession(userId);
            userSessionMapper.save(userSession);
        }

        Integer sessionId = userSessionMapper.findIdByUser(userId);
        return sessionId;
    }

    public void deleteUserSession(Integer id) {
        userSessionMapper.delete(id);
    }
}