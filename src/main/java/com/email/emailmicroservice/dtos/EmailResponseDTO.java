package com.email.emailmicroservice.dtos;

public record EmailResponseDTO(String sender, String to, String text) {
}
