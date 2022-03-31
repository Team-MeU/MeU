package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.TagRequestDto;
import com.codepresso.meu.service.PostService;
import com.codepresso.meu.service.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class TagController {
    private PostService postService;
    private TagService tagService;

    @PostMapping("/tag")
    public ResponseEntity<String> createTag(@RequestBody TagRequestDto tagRequestDto) {

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
