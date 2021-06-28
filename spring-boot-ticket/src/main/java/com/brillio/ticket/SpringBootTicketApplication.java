package com.brillio.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan("com.brillio.ticket.entity")
public class SpringBootTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTicketApplication.class, args);
	}

}
