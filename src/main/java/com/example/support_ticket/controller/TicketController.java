package com.example.support_ticket.controller;

import com.example.support_ticket.dto.*;
import com.example.support_ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketRequest request,
                                                       @AuthenticationPrincipal(expression = "username") String email) {
        return ResponseEntity.ok(ticketService.createTicket(request, email));
    }

    @GetMapping("/my")
    public ResponseEntity<List<TicketResponse>> getMyTickets(@AuthenticationPrincipal(expression = "username") String email) {
        return ResponseEntity.ok(ticketService.getMyTickets(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PutMapping("/{id}/respond")
    public ResponseEntity<Void> respondToTicket(@PathVariable Long id,
                                                @RequestBody TicketResponseRequest request) {
        ticketService.respondToTicket(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id,
                                             @RequestBody TicketStatusUpdateRequest request) {
        ticketService.updateTicketStatus(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id,
                                                        @AuthenticationPrincipal(expression = "username") String email) {
        return ResponseEntity.ok(ticketService.getTicketById(id, email));
    }
}
