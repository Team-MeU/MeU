package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Tag {
    Integer tagId;
    String content;
    Integer tagCount;
    Integer weekCount;

    public Tag(Integer tagId, String content) {
        this.tagId = tagId;
        this.content = content;
    }
}
