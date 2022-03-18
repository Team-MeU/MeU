package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSession {
    Integer sessionId;
    Integer userId;
    Date updatedAt;

    public UserSession(Integer userId) {
        this.userId = userId;
    }
}
