package com.iba.emailsender.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceHelperImpl implements MailServiceHelper {

    private final JavaMailSender javaMailSender;

    @Override
    public SimpleMailMessage createAndSendSimpleMessage(String recipient, String subject, String mailBody) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(mailBody);

        javaMailSender.send(message);

        return message;
    }

}
