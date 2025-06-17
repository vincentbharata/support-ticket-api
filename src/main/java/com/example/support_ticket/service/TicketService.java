package com.example.support_ticket.service;

import com.example.support_ticket.dto.*;
import com.example.support_ticket.model.Ticket;
import com.example.support_ticket.model.User;
import com.example.support_ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;

    public TicketResponse createTicket(TicketRequest request, String email) {
        User user = userService.findByEmail(email).orElseThrow();
        Ticket ticket = Ticket.builder()
                .userId(user.getId())
                .title(request.getTitle())
                .message(request.getMessage())
                .priority(request.getPriority())
                .status(Ticket.Status.OPEN)
                .createdAt(LocalDateTime.now())
                .build();
        return mapToResponse(ticketRepository.save(ticket));
    }

    public List<TicketResponse> getMyTickets(String email) {
        User user = userService.findByEmail(email).orElseThrow();
        return ticketRepository.findByUserId(user.getId()).stream().map(this::mapToResponse).collect(toList());
    }

    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll().stream().map(this::mapToResponse).collect(toList());
    }

    public void respondToTicket(Long id, TicketResponseRequest request) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setResponse(request.getResponse());
        ticket.setStatus(Ticket.Status.IN_PROGRESS);
        ticketRepository.save(ticket);
    }

    public void updateTicketStatus(Long id, TicketStatusUpdateRequest request) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setStatus(request.getStatus());
        ticketRepository.save(ticket);
    }

    public TicketResponse getTicketById(Long id, String email) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        User user = userService.findByEmail(email).orElseThrow();
        if (!ticket.getUserId().equals(user.getId()) && user.getRole() != User.Role.ADMIN) {
            throw new RuntimeException("Unauthorized");
        }
        return mapToResponse(ticket);
    }

    private TicketResponse mapToResponse(Ticket ticket) {
        TicketResponse res = new TicketResponse();
        res.setId(ticket.getId());
        res.setTitle(ticket.getTitle());
        res.setMessage(ticket.getMessage());
        res.setPriority(ticket.getPriority());
        res.setStatus(ticket.getStatus());
        res.setResponse(ticket.getResponse());
        res.setCreatedAt(ticket.getCreatedAt());
        return res;
    }
}
