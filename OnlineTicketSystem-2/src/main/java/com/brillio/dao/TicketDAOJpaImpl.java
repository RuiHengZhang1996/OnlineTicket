package com.brillio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brillio.entity.Ticket;

@Repository
public class TicketDAOJpaImpl implements TicketDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public TicketDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Ticket> findAll() {
		//create a query
		Query theQuery = 
				entityManager.createQuery("from Ticket");
		//execute query and get result list
		List<Ticket> tickets = theQuery.getResultList();
		//return the results
		return tickets;
	}

	@Override
	public Ticket findById(int theId) {
		//get ticket
		Ticket ticket = entityManager.find(Ticket.class, theId);
		//return ticket
		return ticket;
	}

	@Override
	public void save(Ticket theTicket) {
		//save or update
		Ticket ticket = entityManager.merge(theTicket);
		//update with id from db
		theTicket.setId(ticket.getId());

	}

	@Override
	public void deleteById(int theId) {
		//delete object with primary key
		
		Query theQuery = entityManager.createQuery(
				
				"delete from Ticket where id=:ticketId");
		
		theQuery.setParameter("ticketId", theId);
		theQuery.executeUpdate();

	}

}
