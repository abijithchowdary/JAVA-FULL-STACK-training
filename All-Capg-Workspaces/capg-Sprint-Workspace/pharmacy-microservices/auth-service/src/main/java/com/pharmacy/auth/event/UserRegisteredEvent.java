package com.pharmacy.auth.event;

/**
 * Event published after a user is successfully registered (saved in DB).
 *
 * Why an event?
 * - It keeps the registration business logic clean.
 * - It allows side effects (like sending emails) to happen separately.
 */
public class UserRegisteredEvent {

    private final String email;
    private final String name;

    public UserRegisteredEvent(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

