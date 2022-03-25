package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class Likes {
    Integer likesId;
    Integer postId;
    Integer userId;
    Date createdAt;

}



