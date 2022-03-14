package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class UserSession {
    Integer sessionId;
    Integer userId;
    Date updatedAt;
}
