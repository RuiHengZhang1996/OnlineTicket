package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "tickets/list-tickets";
	}
	
	@GetMapping("/showFormForBuy")
	public String showFormForBuy(Model theModel) {
		Ticket theTicket = new Ticket();
		
		theModel.addAttribute("ticket", theTicket);
		
		return "tickets/buy-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int tikcetId, Model theModel) {
		
		System.out.println("**********");
		
		//get the ticket from the service
		Ticket theTicket = ticketService.findById(tikcetId);
		//set ticket as a model attribute
		
		theModel.addAttribute("ticket", theTicket);
		//send over to the form
		
		System.out.println("*********" + theTicket.getId());
		return "tickets/buy-form";
	}
	
	@PostMapping("/buy")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {
		//save the employee
		ticketService.save(theTicket);
		//use a redirect to prevent duplicate submissions 
		return "redirect:/tickets/list";
	}
	
	@GetMapping("/delete") 
	public String delete(@RequestParam("ticketId") int theId) {
		ticketService.deleteById(theId);
		return "redirect:/tickets/list";
	}
	
}
