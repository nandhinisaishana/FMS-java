package com.vinsup.fms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vinsup.fms.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByfullName(String fullName);
//    Optional<User> findByEmailOrFullName(String email, String fullName);

}