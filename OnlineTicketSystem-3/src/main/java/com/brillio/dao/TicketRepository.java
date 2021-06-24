package com.brillio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
