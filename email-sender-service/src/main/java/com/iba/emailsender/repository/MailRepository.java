package com.iba.emailsender.repository;

import com.iba.emailsender.entity.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends MongoRepository<Mail, String> {
}
