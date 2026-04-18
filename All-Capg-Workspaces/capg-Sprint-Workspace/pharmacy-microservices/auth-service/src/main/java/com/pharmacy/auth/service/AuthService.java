package com.pharmacy.auth.service;

import com.pharmacy.auth.dto.LoginRequest;
import com.pharmacy.auth.dto.LoginResponse;
import com.pharmacy.auth.dto.SignupRequest;
import com.pharmacy.auth.event.UserRegisteredEvent;
import com.pharmacy.auth.exception.InvalidCredentialsException;
import com.pharmacy.auth.exception.UserAlreadyExistsException;
import com.pharmacy.auth.exception.UserNotFoundException;
import com.pharmacy.auth.model.Role;
import com.pharmacy.auth.model.User;
import com.pharmacy.auth.repository.UserRepository;
import com.pharmacy.auth.security.JwtService;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final ApplicationEventPublisher eventPublisher;

    public AuthService(UserRepository userRepo,
                       PasswordEncoder encoder,
                       JwtService jwtService,
                       ApplicationEventPublisher eventPublisher) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.eventPublisher = eventPublisher;
    }

    public String signup(SignupRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new UserAlreadyExistsException("Email already registered: " + req.getEmail());
        }
        Set<Role> roles;
        try {
            roles = (req.getRoles() == null || req.getRoles().isEmpty())
                    ? Set.of(Role.CUSTOMER)
                    : req.getRoles().stream().map(Role::valueOf).collect(Collectors.toSet());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role specified. Valid roles: CUSTOMER, ADMIN, PHARMACIST");
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRoles(roles);
        userRepo.save(user);

        // Publish an event AFTER the user is saved.
        // This keeps the registration flow unchanged while allowing side effects
        // (like email sending) to happen separately and asynchronously.
        eventPublisher.publishEvent(new UserRegisteredEvent(user.getEmail(), user.getName()));

        return "User registered successfully";
    }

    public LoginResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + req.getEmail()));
        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        String token = jwtService.generateToken(user.getEmail(), user.getRoles());
        Set<String> roles = user.getRoles().stream().map(Role::name).collect(Collectors.toSet());
        return new LoginResponse(token, user.getName(), roles);
    }

    /**
     * Called automatically when the Spring context is shutting down.
     * Example triggers: Ctrl+C in terminal, stopping the IDE run, or container stop.
     */
    @PreDestroy
    public void onShutdown() {
        log.info("Service is shutting down gracefully...");
        // Simulate cleanup (close resources, flush buffers, etc.)
        log.info("Cleanup completed for AuthService.");
    }
}
