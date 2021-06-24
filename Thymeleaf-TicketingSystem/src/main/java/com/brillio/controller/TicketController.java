package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brillio.entity.Ticket;
import com.brillio.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	//load tickets
	//private List<Ticket> tickets
	private TicketService ticketService;
	
	@Autowired
	public TicketController(TicketService theTicketService) {
		 ticketService = theTicketService;
	}
	
	@GetMapping("/list") 
	public String listTickets(Model theModel) {
		
		List<Ticket> theTicket = ticketService.findAll();
		theModel.addAttribute("tickets", theTicket);
		return "list-tickets";
	}
	
}
