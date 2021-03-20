package com.ticket.service;

import java.util.List;

import com.ticket.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public Ticket findById(int ticketId) throws Exception;

	public void save(Ticket ticketObject);

	public void deleteById(int ticketId);
	
}
