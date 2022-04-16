package com.codepresso.meu.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckPwdRequestDto {
    String password;
    Integer sessionId;
}
