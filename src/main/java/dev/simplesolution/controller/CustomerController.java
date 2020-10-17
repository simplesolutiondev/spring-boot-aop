package dev.simplesolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.simplesolution.domain.Customer;
import dev.simplesolution.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public String view(Model model, @RequestParam(value = "customerId") long customerId) {
		Customer customer = customerService.get(customerId);
		model.addAttribute("customer", customer);
		return "viewCustomer";
	}

}
