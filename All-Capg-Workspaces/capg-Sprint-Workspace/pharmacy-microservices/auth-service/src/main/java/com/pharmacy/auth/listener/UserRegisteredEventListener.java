package com.pharmacy.auth.listener;

import com.pharmacy.auth.event.UserRegisteredEvent;
import com.pharmacy.auth.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Listens for {@link UserRegisteredEvent} and sends a welcome email.
 *
 * Key points:
 * - @EventListener: tells Spring to call this method when the event is published.
 * - @Async: makes email sending non-blocking (runs in a separate thread).
 */
@Component
public class UserRegisteredEventListener {

    private static final Logger log = LoggerFactory.getLogger(UserRegisteredEventListener.class);

    private final EmailService emailService;

    public UserRegisteredEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @Async
    @EventListener
    public void handleUserRegistered(UserRegisteredEvent event) {
        try {
            emailService.sendWelcomeEmail(event.getEmail(), event.getName());
            log.info("Welcome email sent to {}", event.getEmail());
        } catch (Exception ex) {
            // No retry logic by design (requirement: keep it minimal).
            log.warn("Failed to send welcome email to {}: {}", event.getEmail(), ex.getMessage());
        }
    }
}

