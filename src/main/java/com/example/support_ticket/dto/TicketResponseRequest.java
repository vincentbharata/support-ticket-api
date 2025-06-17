package com.example.support_ticket.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TicketResponseRequest {
    @NotBlank private String response;
}
