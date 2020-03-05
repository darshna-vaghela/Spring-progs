package com.customerProfile.main.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.exception.ResourceNotFoundException;
import com.customerProfile.main.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public List<Customer> readAllCustomers() {
		return customerService.readAllCustomer();
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> readCustomer(@PathVariable(value = "customerId") long customerId)
			throws ResourceNotFoundException {
		return customerService.readCustomer(customerId);
	}

	@PostMapping("/")
	public Object addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> editCustomer(@PathVariable(value = "customerId") long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		return customerService.editCustomer(customerDetails, customerId);
	}

	@DeleteMapping("/{customerId}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") long customerId) throws Exception {
		return customerService.deleteCustomer(customerId);
	}

}
