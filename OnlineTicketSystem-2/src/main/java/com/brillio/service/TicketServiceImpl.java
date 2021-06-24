package com.brillio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brillio.dao.TicketDAO;
import com.brillio.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	
	private TicketDAO ticketDAO;
	
	@Autowired
	public TicketServiceImpl(@Qualifier("ticketDAOJpaImpl") TicketDAO theTicketDAO) {
		ticketDAO = theTicketDAO;
	}
	
	@Override
	@Transactional
	public List<Ticket> findAll() {
		
		return ticketDAO.findAll();
	}

	@Override
	@Transactional
	public Ticket findById(int theId) {
		
		return ticketDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Ticket theTicket) {
		ticketDAO.save(theTicket);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ticketDAO.deleteById(theId);
	}

}
