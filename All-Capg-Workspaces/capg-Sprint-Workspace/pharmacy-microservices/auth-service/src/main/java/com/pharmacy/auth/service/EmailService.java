package com.pharmacy.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Sends plain-text emails (no HTML, no attachments).
 * This is intentionally minimal and beginner-friendly.
 */
@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final String fromAddress;

    public EmailService(JavaMailSender mailSender,
                        @Value("${spring.mail.username}") String fromAddress) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
    }

    public void sendWelcomeEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        message.setTo(toEmail);
        message.setSubject("Welcome to Pharmacy App");

        // Simple text email body.
        String safeName = (name == null || name.isBlank()) ? "there" : name.trim();
        message.setText(
                "Hi " + safeName + ",\n\n" +
                "Welcome! Your account has been created successfully.\n\n" +
                "Thanks,\n" +
                "Pharmacy Team"
        );

        mailSender.send(message);
    }
}

