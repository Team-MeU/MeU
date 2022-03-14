package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
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
}
