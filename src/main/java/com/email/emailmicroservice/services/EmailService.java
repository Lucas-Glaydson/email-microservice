package com.email.emailmicroservice.services;

import com.email.emailmicroservice.Enums.StatusEmail;
import com.email.emailmicroservice.Repositories.EmailRepository;
import com.email.emailmicroservice.dtos.EmailResponseDTO;
import com.email.emailmicroservice.dtos.RequestEmailDTO;
import com.email.emailmicroservice.models.EmailModel;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Transactional
    public EmailResponseDTO sendEmail(RequestEmailDTO dto){
        EmailModel newEmail = new EmailModel(dto);
        try {
            var message = new SimpleMailMessage();

            message.setFrom(newEmail.getEmailFrom());
            message.setTo(newEmail.getEmailTo());
            message.setSubject(newEmail.getSubject());
            message.setText(newEmail.getText());
            mailSender.send(message);

            newEmail.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            newEmail.setStatusEmail(StatusEmail.ERROR);
        }

        emailRepository.save(newEmail);
        return new EmailResponseDTO(newEmail.getEmailFrom(), newEmail.getEmailTo(), newEmail.getText());
    }

}
