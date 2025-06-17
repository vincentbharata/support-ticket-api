package com.example.support_ticket.dto;

import com.example.support_ticket.model.Ticket.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketStatusUpdateRequest {
    @NotNull private Status status;
}
