/*package com.vinsup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsup.fms.model.OtpToken;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpToken, Long> {
    Optional<OtpToken> findFirstByEmailAndOtpAndUsedFalseOrderByExpiresAtDesc(String email, String otp);
}
*/