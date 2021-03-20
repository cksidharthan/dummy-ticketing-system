package com.ticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
