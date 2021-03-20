package com.ticket.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ticket.dao.TicketRepository;
import com.ticket.entity.Ticket;
import com.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}
	
	public Ticket findById(int ticketId) throws Exception {
		Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
		Ticket ticketObject = null;
		if (optionalTicket.isPresent()) {
			ticketObject = optionalTicket.get();
		} else {
			throw new Exception("Did not find Asset with id - " + ticketId);
		}
		return ticketObject;
	}

	public void save(Ticket ticketObject) {
		ticketRepository.save(ticketObject);
	}

	public void deleteById(int ticketId) {
		ticketRepository.deleteById(ticketId);
	}
}
