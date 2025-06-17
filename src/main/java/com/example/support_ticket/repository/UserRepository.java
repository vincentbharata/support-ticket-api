package com.example.support_ticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.support_ticket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
