package com.codepresso.meu.controller;

import com.codepresso.meu.controller.dto.ContactRequestDto;
import com.codepresso.meu.service.ContactService;
import com.codepresso.meu.vo.Contact;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<String> saveContact(@RequestBody ContactRequestDto contactDto) {
        Contact contact = contactDto.getContact();
        contactService.sendContactEmail(contact);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
