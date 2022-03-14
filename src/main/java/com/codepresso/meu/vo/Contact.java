package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class Contact {
    Integer contactId;
    String userName;
    String phoneNumber;
    String content;
    Date createdAt;
}
