package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    String email;
    String nickname;
    String password;

    public User getUser() {
        return new User(email, nickname, password);
    }
}
