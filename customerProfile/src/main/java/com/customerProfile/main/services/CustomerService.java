package com.customerProfile.main.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.exception.ResourceNotFoundException;

public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public ResponseEntity<Customer> editCustomer(Customer customer, long customerId) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteCustomer(long customerId) throws Exception;

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException;

	public List<Customer> readAllCustomer();

}
