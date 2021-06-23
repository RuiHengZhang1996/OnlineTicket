package com.studentadmissioncontroller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController								
@RequestMapping("Customer")
public class CustomerController {
	
	
	//is the servlet mapping done automatically  as this would have needed the servlet mapping and the servlet name 
	//this promoting loose coupling in the past is now done automatically 
	
	
	
	
	
	
								//calls the html file 
	@RequestMapping(value="/CustomerForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("CustomerForm");						//takes us to the jsp file 
		return model;
		}
	
	
	
	//https://www.youtube.com/watch?v=OybNc9mLmzs
			//data time object
	
	@RequestMapping("/CustomerForm.html")
	public ModelAndView submitAdmissionForm(@RequestParam("CustomerName") String customerName, @RequestParam("Contact") String contact,@RequestParam("Address") String address,
														@RequestParam("email_address") email coffee, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("depart_date") LocalDate depart_date         
														,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("return_date") LocalDate return_date 				) {
																	//email need to figure 						DATE											DATE
														
		
		
		
		ModelAndView model = new ModelAndView("ThankYouSuccess");			//so the HTML jsp leaving gets the information
		
		//input the getters and setters here,  the many to one relationships would be easier to deal with when the database is connected.
		
		
		
		//depending on how the ppjo will look like the return will change 
		
		model.addObject("msg", "form to show completion away form" +firstname+" "+ lastname + " " +vacation+ " " + coffee);         //"msg"    is needed to get variables appended into the string .
		
		
		return model;
		}
}

