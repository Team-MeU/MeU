package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.CheckPwdRequestDto;
import com.codepresso.meu.controller.dto.PostRequestDto;
import com.codepresso.meu.controller.dto.UserRequestDto;
import com.codepresso.meu.service.UserService;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.Post;
import com.codepresso.meu.vo.User;
import com.codepresso.meu.vo.UserSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserSessionService userSessionService;

    @GetMapping("/test")
    public String test() {
        User user = userService.getUserbyId(1);
        System.out.println("user.getEmail() = " + user.getEmail());
        return "success";
    }

    // sign-up
    @PostMapping("/user")
    public String saveUser(@RequestBody UserRequestDto userRequestDto) {
        User newMember = userRequestDto.getUser();
        newMember.setProfileImg("https://webproject-meu.s3.ap-northeast-2.amazonaws.com/default.png");
        userService.saveUser(newMember);
        return "success";

    }

    //login
    @ResponseBody
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
    // sign-up
    @ResponseBody
    @PostMapping("/checkpwd/post")
    public boolean checkPwd(@RequestBody CheckPwdRequestDto checkPwdRequestDto) {
        System.out.println("call!");

        if(checkPwdRequestDto.getPassword()==null) {
            return false;
        }
        System.out.println("checkPwdRequestDto.getSessionId() = " + checkPwdRequestDto.getSessionId());
        System.out.println("checkPwdRequestDto.getPassword() = " + checkPwdRequestDto.getPassword());
        UserSession userSession = userSessionService.getUserSessionById(checkPwdRequestDto.getSessionId());
        User user = userService.getUserbyId(userSession.getUserId());

        if(!checkPwdRequestDto.getPassword().equals(user.getPassword())){ // 비밀번호 틀림
            return false;
        }
        return true;
    }

    @PutMapping("/user/edit-profile")
    public ResponseEntity<String> modifyUser(@RequestBody @Validated UserRequestDto userRequestDto, @CookieValue("id") Integer sessionId) {
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        Integer logInUserId = userSession.getUserId();
        User user = userRequestDto.getUser();
        user.setUserId(logInUserId);
        userService.modifyUser(user);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestParam("nickname") String followNickname, @CookieValue(name="id", required = false) Integer sessionId) {
        if(sessionId == null){
            System.out.println("No Cookie!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if(userSession == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }

        Integer userId = userSession.getUserId(); //팔로우를 누른 사용자 아이디
        Integer followId = userService.getUserIdByNickname(followNickname); //팔로우 당한 사용자 아이디
        if(!userService.checkFollow(userId, followId)) {
            userService.followUser(userId, followId);
        }
        else {
            System.out.println("already follow!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<String> unfollow(@RequestBody String followNickname, @CookieValue(name="id", required = false) Integer sessionId) {
        if (sessionId == null) {
            System.out.println("No Cookie!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }
        UserSession userSession = userSessionService.getUserSessionById(sessionId);
        if (userSession == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail");
        }

        Integer userId = userSession.getUserId(); //팔로우를 누른 사용자 아이디
        Integer followId = userService.getUserIdByNickname(followNickname); //팔로우 당한 사용자 아이디

        userService.unfollowUser(userId, followId);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
