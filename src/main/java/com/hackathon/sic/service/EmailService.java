package com.hackathon.sic.service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    @Autowired
    private Environment env;

    public void sendAuthorizationCode(String recipientEmail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(env.getProperty("spring.mail.username"));
        message.setTo(recipientEmail);
        message.setSubject("Samsung Hackathon: Код для авторизации");
        message.setText("Ваш код для авторизации: " + code);

        mailSender.send(message);
    }
}
