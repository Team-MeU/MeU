package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Tag {
    Integer tagId;
    String content;
    Integer mapId;
    Integer tagCount;
    Integer weekCount;
}
