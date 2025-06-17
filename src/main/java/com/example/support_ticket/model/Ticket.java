package com.example.support_ticket.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ticket {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @NotBlank private String title;
    @NotBlank private String message;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String response;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    public enum Priority { LOW, MEDIUM, HIGH }
    public enum Status { OPEN, IN_PROGRESS, RESOLVED }
}
