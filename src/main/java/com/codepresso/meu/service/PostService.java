package com.codepresso.meu.service;

import com.codepresso.meu.mapper.PostMapper;
import com.codepresso.meu.vo.Likes;
import com.codepresso.meu.vo.Post;
import com.codepresso.meu.vo.UserSession;
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

    public List<Post> getAllPost() {
        return postMapper.findAll();
    }

    public List<Post> getPostByFeed(Integer id) {
        return postMapper.findByFeed(id);
    }

    public Post getPostById(Integer id) {
        return postMapper.findOne(id);
    }

    public Boolean savePost(Post post, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null) {
            String imgUrl = s3Service.uploadObject(multipartFile);
            post.setImgUrl(imgUrl);
        }
        Integer result = postMapper.save(post);
        return result == 1;
    }

    public Boolean updatePost(Post post, Integer logInUserId) {
        Post originalPost = postMapper.findOne(post.getPostId());
        if(!originalPost.getUserId().equals(logInUserId)) {
            return false;
        }

        Integer result = postMapper.update(post);
        return result == 1;
    }

    public Boolean deletePost(Integer id, Integer logInUserId) {
        Post originalPost = postMapper.findOne(id);

        if(!originalPost.getUserId().equals(logInUserId)) {
            System.out.println("Fail!! ---> Post userId : " + originalPost.getUserId());
            System.out.println("Fail!! ---> Login userId : " + logInUserId);
            return false;
        }

        System.out.println("Success!! ---> Post userId : " + originalPost.getUserId());
        System.out.println("Success!! ---> Login userId : " + logInUserId);

        Integer result = postMapper.delete(id);
        return result == 1;
    }

    public List<Post> getMyPosts(Integer userId) {
        return postMapper.getMyPosts(userId);
    }







    public Boolean likePost(Integer postId, Integer userId) {
        Integer result = postMapper.insertLike(postId, userId);
        return result == 1;
    }

    public List<Likes> getLikesOfPost(Integer postId){
        return postMapper.likesOfPost(postId);
    }
    public List<Likes> getLikesOfUser(Integer userId){ return postMapper.likesOfUser(userId); }
}
