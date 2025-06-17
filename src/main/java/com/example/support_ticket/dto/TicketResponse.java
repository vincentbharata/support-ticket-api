package com.example.support_ticket.dto;

import com.example.support_ticket.model.Ticket.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TicketResponse {
    private Long id;
    private Long userId;
    private String title;
    private String message;
    private Priority priority;
    private Status status;
    private String response;
    private LocalDateTime createdAt;
}
