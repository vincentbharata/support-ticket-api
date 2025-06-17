package com.example.support_ticket.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    public enum Status { OPEN, IN_PROGRESS, RESOLVED }
    public enum Priority { LOW, MEDIUM, HIGH }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Assuming this is the ID of the user who created the ticket

    private String title;
    private String message;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String response;
    private LocalDateTime createdAt;
}
