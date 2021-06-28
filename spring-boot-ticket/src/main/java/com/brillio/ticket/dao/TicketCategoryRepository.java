package com.brillio.ticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.brillio.ticket.entity.TicketCategory;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "ticketCategory", path="ticket-category")
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long>{
	
}
