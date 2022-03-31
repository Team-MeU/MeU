package com.codepresso.meu.service;

import com.codepresso.meu.controller.dto.TagRequestDto;
import com.codepresso.meu.mapper.TagMapper;
import com.codepresso.meu.vo.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class TagService {
    private TagMapper tagMapper;

    public List<String> createTagList(String content) {
        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(content);
        List<String> tagList = new ArrayList<String>();

        while(mat.find()) {
            tagList.add(mat.group(1));
        }
        System.out.println("Create HashTags Success! -----> " + tagList);

        for(String tag : tagList) {
            System.out.println("tag : " + tag);
        }

        return tagList;
    }

    public Tag findTag(String tag) {
        return tagMapper.findTag(tag);
    }
}
