package com.email.emailmicroservice.models;

import com.email.emailmicroservice.Enums.StatusEmail;
import com.email.emailmicroservice.dtos.RequestEmailDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Data
@NoArgsConstructor
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String owner;
    @Column(name = "email_from")
    private String emailFrom;
    @Column(name = "email_to")
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(name = "send_data_email")
    private LocalDateTime sendDataEmail;
    @Column(name = "status_email")  @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;

    public EmailModel(RequestEmailDTO dto){
        this.emailFrom = dto.emailFrom();
        this.emailTo = dto.emailTo();
        this.text = dto.text();
        this.owner = dto.owner();
        this.subject = dto.subject();
        this.sendDataEmail = LocalDateTime.now();
    }

}
