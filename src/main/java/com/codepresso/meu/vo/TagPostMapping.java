package com.codepresso.meu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class TagPostMapping {
//    Integer mapId;
    Integer tagId;
    Integer postId;
    String content;

    public TagPostMapping(Integer tagId, Integer postId) {
//        this.mapId = mapId;
        this.tagId = tagId;
        this.postId = postId;
    }
}
