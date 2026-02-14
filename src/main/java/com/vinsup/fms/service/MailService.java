package com.vinsup.fms.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailService {
    private final JavaMailSender mailSender;
    public MailService(JavaMailSender mailSender) { this.mailSender = mailSender; }
    
    public void sendOtpEmail(String to, String otp, int expiryMinutes) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("OTP for FMS");
        msg.setText("Your OTP is: " + otp + "\nExpires in " + expiryMinutes + " minutes.");
        mailSender.send(msg);
    }
}

