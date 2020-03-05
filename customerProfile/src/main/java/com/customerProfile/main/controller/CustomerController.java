package com.customerProfile.main.controller;

import java.util.HashMap;
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
import com.customerProfile.main.repository.CustomerRepository;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/showall")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	
	@GetMapping("/read/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)	.orElseThrow(() -> new ResourceNotFoundException("Customer not found on : " + customerId));
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("/add")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/edit/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "customerId") long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer c = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on : " + customerId));
		c.setFirstName(customerDetails.getFirstName());
		c.setLastName(customerDetails.getLastName());
		c.setGender(customerDetails.getGender());
		c.setDob(customerDetails.getDob());
		c.setHouseNo(customerDetails.getHouseNo());
		c.setStreetName(customerDetails.getStreetName());
		c.setArea(customerDetails.getArea());
		c.setCity(customerDetails.getCity());
		c.setPincode(customerDetails.getPincode());
		c.setUpdatedAt(customerDetails.getUpdatedAt());
		


		final Customer updatedCustomer = customerRepository.save(c);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") long customerId) throws Exception {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" customer not found  on : " + customerId));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
