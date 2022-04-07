package com.codepresso.meu.vo;
import java.util.Date;


public class Contact {
    Integer contactId;
    String username;
    String email;
    String content;
    Date createdAt;

    public Contact(Integer contactId, String username, String email, String content) {
        this.contactId = contactId;
        this.username = username;
        this.email = email;
        this.content = content;
    }
}
