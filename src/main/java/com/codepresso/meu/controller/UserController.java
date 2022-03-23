package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.UserRequestDto;
import com.codepresso.meu.service.UserService;
import com.codepresso.meu.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        User user = userService.getUserbyId(1);
        System.out.println("user.getEmail() = " + user.getEmail());
        return "success";
    }

    // sign-up
    @PostMapping("/user")
    public String saveUser(@RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto.getUser());
        return "success";
    }

    //login
    @PostMapping("/user/login")
    public ResponseEntity loginUser(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        Integer sessionId = userService.loginUser(userRequestDto.getUser());
        System.out.println("sessionId = " + sessionId);
        Cookie cookie = new Cookie("id", String.valueOf(sessionId));
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
