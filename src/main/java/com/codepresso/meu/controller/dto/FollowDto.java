package com.codepresso.meu.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowDto {
    Integer followCount;
    List<Integer> users;
}
