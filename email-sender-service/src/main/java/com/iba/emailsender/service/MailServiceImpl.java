package com.iba.emailsender.service;

import com.iba.emailsender.entity.Mail;
import com.iba.emailsender.entity.MailStatus;
import com.iba.emailsender.repository.MailRepository;
import com.iba.library.dto.req.emailsender.SimpleMailReq;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
@AllArgsConstructor
@Log4j2
public class MailServiceImpl implements MailService {

    private final MailServiceHelper mailServiceHelper;
    private final MailRepository mailRepository;

    @Override
    public void sendSimpleMail(SimpleMailReq simpleMailReq) {

        final SimpleMailMessage message = createAndSendSimpleMessage(simpleMailReq);
        final Mail mail = new Mail(message);

        mail.setStatus(MailStatus.SENT);

        mailRepository.save(mail);
    }

    private SimpleMailMessage createAndSendSimpleMessage(final SimpleMailReq simpleMailReq) {

        final String recipient = simpleMailReq.getRecipient();
        final String subject = simpleMailReq.getSubject();
        final String mailBody = simpleMailReq.getMailBody();

        return mailServiceHelper.createAndSendSimpleMessage(recipient, subject, mailBody);
    }

}
