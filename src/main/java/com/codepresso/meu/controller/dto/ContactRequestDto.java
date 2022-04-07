package com.codepresso.meu.controller.dto;

import com.codepresso.meu.vo.Contact;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactRequestDto {
    Integer contactId;
    String username;
    String email;
    String content;

    public Contact getContact() {
        return new Contact(this.contactId, this.username, this.email, this.content);
    }
}
