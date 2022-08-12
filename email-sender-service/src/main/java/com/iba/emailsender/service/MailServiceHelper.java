package com.iba.emailsender.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailServiceHelper {

    SimpleMailMessage createAndSendSimpleMessage(final String recipient, final String subject, final String mailBody);

}
