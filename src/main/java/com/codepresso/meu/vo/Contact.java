package com.codepresso.meu.vo;

import javax.xml.crypto.Data;

public class Contact {
    Integer contactId;
    String username;
    String email;
    String content;
    Data createdAt;

    public Contact(Integer contactId, String username, String email, String content) {
        this.contactId = contactId;
        this.username = username;
        this.email = email;
        this.content = content;
    }
}