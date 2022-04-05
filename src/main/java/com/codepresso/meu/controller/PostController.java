package com.codepresso.meu.controller;


import com.codepresso.meu.controller.dto.LikesRequestDto;
import com.codepresso.meu.controller.dto.PostRequestDto;
import com.codepresso.meu.controller.dto.PostResponseDto;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.service.TagService;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.Likes;
import com.codepresso.meu.vo.Post;
import com.codepresso.meu.vo.TagPostMapping;
import com.codepresso.meu.vo.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class PostController {
    private PostService postService;
    private UserSessionService userSessionService;
    private TagService tagService;



    @GetMapping("/post")
    public List<PostResponseDto> getPostList(@RequestParam Integer page) {
        List<Post> postList = postService.getPostByPage(page);

        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post : postList) {
            postResponseDtos.add(new PostResponseDto(post));
        }
        return postResponseDtos;
    }



    @PostMapping("/post")
    public ResponseEntity<String> createPost(@Validated PostRequestDto postDto, @RequestPart(value = "file", required = false) MultipartFile multipartFile, @CookieValue("id") Integer sessionId) throws IOException {
            UserSession userSession = userSessionService.getUserSessionById(sessionId);

            if(userSession == null ) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
            }
            Integer logInUserId = userSession.getUserId();

            Post post = postDto.getPost();
            post.setUserId(logInUserId);

            if (multipartFile != null) {
                log.info("upload file name : {}", multipartFile.getOriginalFilename());
            }

            postService.savePost(post, multipartFile);
            tagService.createTagList(post);

            return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @PutMapping("/post")
    public ResponseEntity<String> updatePost(@Validated PostRequestDto postDto, @RequestPart(value = "file", required = false) MultipartFile multipartFile, @CookieValue("id") Integer sessionId) throws IOException {
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        System.out.println("update userSession : " + userSession);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        Integer logInUserId = userSession.getUserId();
        Post post = postDto.getPost();
        Boolean result = postService.updatePost(post, multipartFile, logInUserId);

        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
    }

    @DeleteMapping("/post")
    public ResponseEntity<String> deletePost(@RequestParam Integer id, @CookieValue("id") Integer sessionId){
        UserSession userSession = userSessionService.getUserSessionById(sessionId);

        Integer logInUserId = userSession.getUserId();

        Boolean result = postService.deletePost(id, logInUserId);

        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
    }

    @PostMapping("/post/like")
    public ResponseEntity<String> createLike(@RequestBody LikesRequestDto likeDto, @CookieValue("id") Integer sessionId) throws IOException {
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        Boolean result = false;

        if(!(postService.checkExistLike(likeDto.getPostId(),userSession.getUserId()))) result = postService.likePost(likeDto.getPostId(), userSession.getUserId());
        else result = postService.deleteLike(likeDto.getPostId(), userSession.getUserId());


        if(result) { return ResponseEntity.status(HttpStatus.OK).body("success");}
        else { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");}
    }

    @GetMapping("/post/likes")
    public List<Likes> findLikesOfUser(@RequestParam Integer userId){
        List<Likes> likesOfUser = postService.getLikesOfUser(userId);
        return likesOfUser;
    }

    @GetMapping("post/count")
    public Integer getPostMaxCount(){ return postService.getAllPost().size();
    }

}
