package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Contact;
import lombok.Getter;

@Getter
public class ContactResponseDto {
    Integer contactId;
    String username;
    String email;
    String content;

    public ContactResponseDto(Contact contact) {
        this.contactId = contact.getContactId();
        this.username = contact.getUsername();
        this.email = contact.getEmail();
        this.content = contact.getContent();
    }
}

