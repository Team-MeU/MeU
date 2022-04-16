package com.codepresso.meu.service;

import com.codepresso.meu.mapper.PostMapper;
import com.codepresso.meu.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrendingService {
    private PostMapper postMapper;
    private CommentService commentService;
    private S3Service s3Service;
    private TagService tagService;

    private static Integer viewPostSize = 6;

    public List<Post> getTrendingPage() {
        System.out.println("트렌드 서비스 실행" );
        Integer limit = 30;
        System.out.println(postMapper.findTrending(limit));
        return postMapper.findTrending(limit);
    }
}