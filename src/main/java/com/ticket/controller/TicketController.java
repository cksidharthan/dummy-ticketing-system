package com.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Asset;
import com.ticket.entity.Ticket;
import com.ticket.helper.TicketAppResponse;
import com.ticket.service.AssetService;
import com.ticket.service.TicketService;


@RestController
@CrossOrigin
public class TicketController {
	private TicketService ticketService;
	private AssetService assetService;
	
	@Autowired
	public TicketController(TicketService ticketService, AssetService assetService) {
		this.ticketService = ticketService;
		this.assetService = assetService;
	}
	
	@GetMapping("/tickets")
	public TicketAppResponse<List<Ticket>> getTickets() {
		List<Ticket> ticketList = ticketService.findAll();
		return new TicketAppResponse<List<Ticket>>(HttpStatus.OK, "Assets Found", ticketList);
	}
	
	@GetMapping(path="/getTicket/{ticket_id}")
	public TicketAppResponse<Ticket> getTicketbyId(@PathVariable int ticket_id) {
		Ticket ticketObject;
		try {
			ticketObject = ticketService.findById(ticket_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new TicketAppResponse<Ticket>(HttpStatus.OK, "Asset Not Found", null);
		}
		return new TicketAppResponse<Ticket>(HttpStatus.OK, "Asset Found", ticketObject);
	}
	
	@PostMapping(path="/addTicket")
	public TicketAppResponse<String> addTicket(@RequestBody Ticket ticketObject) throws Exception {
		try {
			Asset optionalAsset = assetService.findById(ticketObject.getAsset().getId());
			ticketObject.setAsset(optionalAsset);
		} catch (Exception e) {
			return new TicketAppResponse<String>(HttpStatus.NOT_ACCEPTABLE, "Ticket Not Added", "Error Adding ticket - Specified Asset not found. Check the asset id");
		}
		ticketService.save(ticketObject);
		return new TicketAppResponse<String>(HttpStatus.OK, "Ticket added", "Ticket Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteTicket/{ticket_id}")
	public TicketAppResponse<String> deleteTicketById(@PathVariable int ticket_id) {
		try {
			ticketService.deleteById(ticket_id);
			return new TicketAppResponse<String>(HttpStatus.OK, "Ticket deleted", "Ticket Deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new TicketAppResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}
