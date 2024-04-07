package com.email.emailmicroservice.dtos;

import com.email.emailmicroservice.Enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RequestEmailDTO(
        @NotBlank
        String owner,
        @NotBlank @Email
        String emailFrom,
        @NotBlank @Email
        String emailTo,
        @NotBlank
        String subject,
        @NotBlank
        String text
) {
}
