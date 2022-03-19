package com.codepresso.meu.controller;


import com.codepresso.meu.controller.dto.PostRequestDto;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.vo.Post;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class PostController {
    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody @Validated PostRequestDto postDto) {
        Post post = postDto.getPost();
        postService.savePost(post);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @PutMapping("/post")
    public ResponseEntity<String> updatePost(@RequestBody @Validated PostRequestDto postDto) {
        Post post = postDto.getPost();
        postService.updatePost(post);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @DeleteMapping("/post")
    public ResponseEntity<String> deletePost(@RequestParam Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

}
