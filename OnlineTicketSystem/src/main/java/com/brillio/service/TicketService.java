package com.brillio.service;

import java.util.List;

import com.brillio.entity.Ticket;

public interface TicketService {
	public List<Ticket> findAll();
	
	public Ticket findById(int theId);
	
	public void save(Ticket theTicket);
	
	public void deleteById(int theId);
}
