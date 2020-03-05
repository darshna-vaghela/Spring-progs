package com.customerProfile.main.dao;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.exception.ResourceNotFoundException;

public interface CustomerDao {
	public Customer addCustomer(Customer customer);

	public Map<String, Boolean> deleteCustomer(long customerId) throws Exception;

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException;

	public List<Customer> readAllCustomer();

	public ResponseEntity<Customer> editCustomer(long customerId, @Valid Customer customerDetails)
			throws ResourceNotFoundException;
}
