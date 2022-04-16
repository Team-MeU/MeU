package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.UserSession;
import lombok.Getter;

@Getter
public class UserSessionResponseDto {
    Integer sessionId;
    Integer userId;
    String name;

    public UserSessionResponseDto(UserSession userSession) {
        this.sessionId = userSession.getSessionId();
        this.userId = userSession.getUserId();
    }
}
