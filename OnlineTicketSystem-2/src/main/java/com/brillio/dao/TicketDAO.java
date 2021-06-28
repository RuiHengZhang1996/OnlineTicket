package com.brillio.dao;

import java.util.List;

import com.brillio.entity.Ticket;

public interface TicketDAO {
	
	public List<Ticket> findAll();
	
	public Ticket findById(int theId);
	
	public void save(Ticket theTicket);
	
	public void deleteById(int theId);
}
