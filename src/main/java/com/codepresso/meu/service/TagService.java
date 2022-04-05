package com.codepresso.meu.service;

import com.codepresso.meu.mapper.TagMapper;
import com.codepresso.meu.mapper.TagPostMapper;
import com.codepresso.meu.vo.Post;
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
    private TagPostMapper tagPostMapper;

    public void createTagList(Post post) {
        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(post.getContent());
        List<String> tagList = new ArrayList<>();

        while(mat.find()) {
            tagList.add((mat.group(1)));
        }

        System.out.println("Create HashTags Success! -----> " + tagList);
        saveTag(tagList, post.getPostId());

    }

    public Boolean saveTag(List<String> tagList, Integer postId) {
        Integer result = 1;

        for (String tag : tagList) {
            Tag findResult = tagMapper.findTagByContent(tag);
            System.out.println("find tag ---> " + findResult);

            // 등록된 태그가 아니라면 태그부터 추가
            if (findResult == null) {
                tagMapper.saveTag(tag);
            }

            // 태그-포스트 매핑 테이블에 데이터 추가
            Tag findTag = tagMapper.findTagByContent(tag);
            result = tagPostMapper.saveTagPost(findTag.getTagId(), postId);
        }

        System.out.println(result);
        return result == 1;
    }

    public boolean deleteTagPost(Integer postId) {
        Integer result = tagPostMapper.deleteTagPost(postId);
        return result == 1;
    }

}
