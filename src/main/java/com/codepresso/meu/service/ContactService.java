package com.codepresso.meu.service;

import com.codepresso.meu.mapper.ContactMapper;
import com.codepresso.meu.vo.Contact;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final JavaMailSender mailSender;
    private ContactMapper contactMapper;

    public ContactService(JavaMailSender javaMailSender, ContactMapper contactMapper) {
        this.mailSender = javaMailSender;
        this.contactMapper = contactMapper;
    }

    @Value("${spring.mail.username}")
    private String sender;

    public boolean sendContactEmail(Contact contact) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(contact.getEmail());
        message.setFrom(sender);
        message.setSubject("Hello " + contact.getUsername() + "! This is MeU.");
        message.setText("Hello " + contact.getUsername() + "! This is MeU.\n\n" +
                "We checked the inquiry email from " + contact.getUsername() + ".\n\n" +
                "---------------------Your Contact Message-------------------\n" +
                contact.getContent() + "\n" +
                "----------------------------------------------------------------------\n\n" +
                "We will send you a reply email within 3 days regarding the related matters.\n" +
                "Thank you for using MeU.\nHave a nice day!");
        mailSender.send(message);
        Integer result = contactMapper.saveContact(contact);

        return result == 1;
    }
}
