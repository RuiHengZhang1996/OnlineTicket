package com.brillio.ticket.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.brillio.ticket.entity.Ticket;

@CrossOrigin("http://localhost:4200")
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	Page<Ticket> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	
	Page<Ticket> findByNameContaining(@RequestParam("name") String name, Pageable pageble);
}
