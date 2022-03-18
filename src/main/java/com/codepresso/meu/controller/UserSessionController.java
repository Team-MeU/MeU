package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.UserSessionResponseDto;
import com.codepresso.meu.service.UserSessionService;
import com.codepresso.meu.vo.UserSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserSessionController {
    private UserSessionService userSessionService;

    @GetMapping("/user/session")
    public UserSessionResponseDto getSession(@RequestParam Integer id) {
        UserSession userSession = userSessionService.getUserSessionById(id);
        return new UserSessionResponseDto(userSession);
    }

    @DeleteMapping("/user/session")
    public ResponseEntity deleteSession(@RequestParam Integer id) {
        userSessionService.deleteUserSession(id);
        return ResponseEntity.ok().build();
    }
}

