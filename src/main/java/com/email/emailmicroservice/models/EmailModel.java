package com.email.emailmicroservice.models;

import com.email.emailmicroservice.Enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emails")
@Data
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String owner;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private String sendDataEmail;
    private StatusEmail statusEmail;


}
