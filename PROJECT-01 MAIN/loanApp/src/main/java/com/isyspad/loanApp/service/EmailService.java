package com.isyspad.loanApp.service;

public interface EmailService {

    void sendScheduledEmail();

    void sendHtmlEmail(String to, String subject, String htmlMessage);
}
