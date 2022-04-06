package com.codepresso.meu.service;

import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.mapper.PostMapper;
import com.codepresso.meu.vo.Likes;
import com.codepresso.meu.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private PostMapper postMapper;
    private S3Service s3Service;
    private TagService tagService;

    private static Integer viewPostSize = 6;

    public List<Post> getAllPost() {
        return postMapper.findAll();
    }
    public List<Post> getPostByPage(Integer page) {
        int limit = page * viewPostSize;
        return postMapper.findByPage(limit);
    }


    public List<Post> getPostByFeed(Integer id) {
        return postMapper.findByFeed(id);
    }
    public Post getPostById(Integer id) {
        return postMapper.findOne(id);
    }

    public boolean savePost(Post post, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null) {
            String imgUrl = s3Service.uploadObject(multipartFile);
            post.setImgUrl(imgUrl);
        }
        Integer result = postMapper.save(post);
        tagService.createTagList(post);
        return result == 1;
    }

    public boolean updatePost(Post post, MultipartFile multipartFile, Integer logInUserId) throws IOException {
        Post originalPost = postMapper.findOne(post.getPostId());

        if(!originalPost.getUserId().equals(logInUserId)) {
            return false;
        }

        if (multipartFile != null) {
            String imgUrl = s3Service.uploadObject(multipartFile);
            post.setImgUrl(imgUrl);
        }

        Integer result = postMapper.update(post);
        tagService.createTagList(post);
        return result == 1;
    }

    public boolean deletePost(Integer id, Integer logInUserId) {
        Post originalPost = postMapper.findOne(id);

        if(!originalPost.getUserId().equals(logInUserId)) {
            return false;
        }

        Integer result = postMapper.delete(id);
        tagService.deleteTagPost(id);
        return result == 1;
    }

    public List<Post> getMyPosts(Integer userId) {
        return postMapper.getMyPosts(userId);
    }

    public Boolean likePost(Integer postId, Integer userId) {
        Integer result = postMapper.insertLike(postId, userId);
        return result == 1;
    }

    public Boolean deleteLike(Integer postId, Integer userId) {
        Integer result = postMapper.deleteLike(postId, userId);
        return result == 1;
    }

    public Boolean checkExistLike(Integer postId, Integer userId) {
        Integer check = postMapper.checkLike(postId, userId);
        if(check > 0) return true;
        else return false;
    }
    public List<Likes> getLikesOfPost(Integer postId){
        return postMapper.likesOfPost(postId);
    }
    public List<Likes> getLikesOfUser(Integer userId){ return postMapper.likesOfUser(userId); }


    public Integer getViewPostSize(){
        return viewPostSize;
    }
}
