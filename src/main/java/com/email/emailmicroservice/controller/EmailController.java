package com.email.emailmicroservice.controller;

import com.email.emailmicroservice.dtos.EmailResponseDTO;
import com.email.emailmicroservice.dtos.RequestEmailDTO;
import com.email.emailmicroservice.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<EmailResponseDTO> sendEmail(@RequestBody RequestEmailDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(emailService.sendEmail(dto));
    }
}
