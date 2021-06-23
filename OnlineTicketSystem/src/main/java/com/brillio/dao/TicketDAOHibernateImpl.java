package com.brillio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brillio.entity.Ticket;

@Repository
public class TicketDAOHibernateImpl implements TicketDAO {
	
	
	//define field for entity
	
	private EntityManager entityManager;
	//set up constructor injection
	
	@Autowired
	public TicketDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<Ticket> findAll() {
		
		// get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Query<Ticket> theQuery = 
				currentSession.createQuery("from Ticket", Ticket.class);
		//execute the query and get result list
		List<Ticket> tickets = theQuery.getResultList();
		//return the results
		return tickets;
	}


	@Override
	public Ticket findById(int theId) {
		
		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the ticket
		Ticket theTicket = 
				currentSession.get(Ticket.class, theId);
		//return the ticket
		return theTicket;
		
	}


	@Override
	public void save(Ticket theTicket) {
		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//save ticket
		currentSession.saveOrUpdate(theTicket);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the session
		Session currentSession = entityManager.unwrap(Session.class);
		//delete
		Query theQuery = 
				currentSession.createQuery(
							"delete from ticket where id=:ticketId"
						);
		theQuery.setParameter("ticketId", theId);
		theQuery.executeUpdate();
	}

}
