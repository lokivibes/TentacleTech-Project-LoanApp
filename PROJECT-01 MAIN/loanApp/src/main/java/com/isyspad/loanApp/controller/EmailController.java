package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleEmail() {
        try {
            emailService.sendScheduledEmail();
            return ResponseEntity.ok("Email scheduled for sending.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to schedule email: " + e.getMessage());
        }
    }
}
