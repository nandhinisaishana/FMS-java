package com.vinsup.fms.service;

import java.time.Duration;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;@Service
public class OtpRedisService {
    private final StringRedisTemplate redisTemplate;
    @Value("${app.otp-expiration-minutes}") private int otpExpiry;

    public OtpRedisService(StringRedisTemplate redisTemplate) { this.redisTemplate = redisTemplate; }

    public String generateAndSaveOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(1_000_000));
        redisTemplate.opsForValue().set("otp:" + email, otp, Duration.ofMinutes(otpExpiry));
        return otp;
    }

    public boolean validateOtp(String email, String otp) {
        String key = "otp:" + email;
        String saved = redisTemplate.opsForValue().get(key);
        if(saved != null && saved.equals(otp)) {
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }
}
