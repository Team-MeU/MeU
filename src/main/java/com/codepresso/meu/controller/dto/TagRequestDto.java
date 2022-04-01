package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Tag;
import com.codepresso.meu.vo.TagPostMapping;
import lombok.Getter;

@Getter
public class TagRequestDto {
    Integer tagId;
    String content;
    Integer mapId;
    Integer postId;

    public TagRequestDto(TagPostMapping tagPostMapping) {
        this.mapId = tagPostMapping.getMapId();
        this.tagId = tagPostMapping.getTagId();
        this.postId = tagPostMapping.getPostId();
        this.content = tagPostMapping.getContent();

    }
}
