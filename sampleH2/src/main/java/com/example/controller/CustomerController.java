package com.example.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.CustomerEntity;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CustomerRepository;

@RestController

public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	/**
	 * Get all customers list.
	 *
	 * @return the list
	 */
	@GetMapping("/customers")
	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	/**
	 * Gets customers by id.
	 *
	 * @param customerId the customer id
	 * @return the customers by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable(value = "id") int customerId)
			throws ResourceNotFoundException {
		CustomerEntity customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on : " + customerId));
		return ResponseEntity.ok().body(customer);
	}
	/**
	 * Create user customers.
	 *
	 * @param user the customer
	 * @return the customer
	 */
	@PostMapping("/customers")

	public CustomerEntity createCustomer(@Valid @RequestBody CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	/**
	 * Update customer response entity.
	 *
	 * @param customersId      the customer id
	 * @param customersDetails the customer details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerEntity> updatecustomer(@PathVariable(value = "id") int customerId,
			@Valid @RequestBody CustomerEntity customerDetails) throws ResourceNotFoundException {
		CustomerEntity c = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on : " + customerId));
		c.setEmail(customerDetails.getEmail());
		c.setFirstName(customerDetails.getFirstName());
		c.setLastName(customerDetails.getLastName());
		

		final CustomerEntity updatedCustomer = customerRepository.save(c);
		return ResponseEntity.ok(updatedCustomer);
	}

	/**
	 * Delete customer map.
	 *
	 * @param customerId the customer id
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") int customerId) throws Exception {
		CustomerEntity customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" User not found  on : " + customerId));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
