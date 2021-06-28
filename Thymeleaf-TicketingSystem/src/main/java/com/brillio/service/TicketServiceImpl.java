package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brillio.dao.TicketRepository;
import com.brillio.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	
	private TicketRepository ticketRepository;
	
	@Autowired
	public TicketServiceImpl(TicketRepository theTicketRepository) {
		ticketRepository = theTicketRepository;
	}
	
	@Override
	public List<Ticket> findAll() {
		
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findById(int theId) {
		Ticket theTicket = null;
		Optional<Ticket> result = ticketRepository.findById(theId);
		if(result.isPresent()) theTicket = result.get();
		else throw new RuntimeException("Did not find id" + theId);
		return theTicket;
	}

	@Override
	public void save(Ticket theTicket) {
		ticketRepository.save(theTicket);
	}

	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);
	}

}
