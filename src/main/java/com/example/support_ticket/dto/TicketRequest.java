package com.example.support_ticket.dto;

import com.example.support_ticket.model.Ticket.Priority;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TicketRequest {
    @NotBlank private String title;
    @NotBlank private String message;
    @NotNull private Priority priority;
}