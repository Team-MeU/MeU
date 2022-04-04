package com.codepresso.meu.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FeedRequestDto {
    Integer page;
    Integer userId;

    public FeedRequestDto(){}

    public FeedRequestDto(Integer defaultPage, Integer defaultUser){
        this.page = defaultPage;
        this.userId = defaultUser;
    }

}
