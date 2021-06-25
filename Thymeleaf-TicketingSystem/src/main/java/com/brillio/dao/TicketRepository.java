package com.brillio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
}
