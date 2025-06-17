package com.example.support_ticket.repository;

import com.example.support_ticket.model.Ticket;
import com.example.support_ticket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser(User user);
}