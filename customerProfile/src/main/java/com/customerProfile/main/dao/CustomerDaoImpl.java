package com.customerProfile.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.exception.ResourceNotFoundException;
import com.customerProfile.main.repository.CustomerRepository;


@Qualifier("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public ResponseEntity<Customer> editCustomer(@PathVariable(value = "customerId") long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer c = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on : " + customerId));
		c.setEmail(customerDetails.getEmail());
		c.setPhoneNo1(customerDetails.getPhoneNo1());
		c.setPhoneNo2(customerDetails.getPhoneNo2());
		c.setFirstName(customerDetails.getFirstName());
		c.setLastName(customerDetails.getLastName());
		c.setGender(customerDetails.getGender());
		c.setDateOfBirth(customerDetails.getDateOfBirth());
		c.setHouseNo(customerDetails.getHouseNo());
		c.setStreetAddress(customerDetails.getStreetAddress());
		c.setLandmark(customerDetails.getLandmark());
		c.setArea(customerDetails.getArea());
		c.setCity(customerDetails.getCity());
		c.setState(customerDetails.getState());
		c.setPincode(customerDetails.getPincode());
		c.setUpdatedAt(customerDetails.getUpdatedAt());

		final Customer updatedCustomer = customerRepository.save(c);
		return ResponseEntity.ok(updatedCustomer);

	}

	@Override
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") long customerId) throws Exception {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" customer not found  on : " + customerId));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public ResponseEntity<Customer> readCustomer(@PathVariable(value = "customerId") long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on : " + customerId));
		return ResponseEntity.ok().body(customer);
	}

	@Override
	public List<Customer> readAllCustomer() {
		return customerRepository.findAll();
	}
}
