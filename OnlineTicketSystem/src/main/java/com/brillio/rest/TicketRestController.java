package com.brillio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.entity.Ticket;
import com.brillio.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketRestController {
	
	//quickly inject employee dao
	private TicketService ticketService;
	
	@Autowired
	public TicketRestController(TicketService theTicketService) {
		ticketService = theTicketService;
	}
	
	//expose "/ticket" and return the list of tickets
	@GetMapping("/tickets")
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}
	
	//add mapping for GET /tickets/{ticketId}
	
	@GetMapping("/tickets/{ticketId}")
	public Ticket getTicket(@PathVariable int ticketId) {
		
		Ticket theTicket = ticketService.findById(ticketId);
		if(theTicket == null) throw new RuntimeException("ticket id not found");
		return theTicket;
	}
	
	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket theTicket) {
		//also just in case they pass id in json
		
		//set id to 0
		theTicket.setId(0);
		ticketService.save(theTicket);
		
		return theTicket;
	}
	
	@PutMapping("/tickets")
	public Ticket updateTicket(@RequestBody Ticket theTicket) {
		
		ticketService.save(theTicket);
		return theTicket;
	}
	
	
}
