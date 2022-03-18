package com.codepresso.meu.vo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
    Integer userId;
    String email;
    String userName;
    String password;
    String profileImg;
    Date birthDate;
    Integer gender;
    Integer videoSet;
    Integer notificationSet;
    Date createdAt;
    Date updatedAt;
    String nickname;
    String introduce;

    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }
}
