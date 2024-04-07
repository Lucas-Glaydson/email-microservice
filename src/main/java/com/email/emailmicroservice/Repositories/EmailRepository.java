package com.email.emailmicroservice.Repositories;

import com.email.emailmicroservice.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, String> {

}
