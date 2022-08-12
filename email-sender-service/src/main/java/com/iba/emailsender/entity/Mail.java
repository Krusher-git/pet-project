package com.iba.emailsender.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.mail.SimpleMailMessage;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Document("mails")
@Getter
@Setter
@NoArgsConstructor
public class Mail {

    @Id
    private String id = UUID.randomUUID().toString();
    private Set<String> recipients;
    private String subject;
    private String text;

    private MailStatus status = MailStatus.PENDING;

    public Mail(SimpleMailMessage simpleMailMessage) {
        this.recipients = Set.of(Objects.requireNonNull(simpleMailMessage.getTo()));
        this.subject = simpleMailMessage.getSubject();
        this.text = simpleMailMessage.getText();
    }

}
