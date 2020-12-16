package com.udemy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.springdemo.entity.Customer;
import com.udemy.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject DAO into controller
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model themodel) {
		
		//get the customer from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customer to model
		themodel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

	
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create new model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, 
								Model theModel)
	{
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set the customer as model attribute to prepopulate form
		theModel.addAttribute("customer", theCustomer);
		
		//send it t the form
		
		
		return "customer-form";
		
	}

	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
	

