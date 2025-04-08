package com.bsanju.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    private final String toEmail = "bsanju.java@gmail.com";

    public void sendEmail(String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom("fastbootsanju@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
