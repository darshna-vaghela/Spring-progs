package com.customerProfile.main.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.dao.CustomerDao;
import com.customerProfile.main.exception.ResourceNotFoundException;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	public ResponseEntity<Customer> editCustomer(Customer customer, long customerId) throws ResourceNotFoundException {
		return customerDao.editCustomer(customerId, customer);
	}

	public Map<String, Boolean> deleteCustomer(long customerId) throws Exception {
		return customerDao.deleteCustomer(customerId);
	}

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException {
		return customerDao.readCustomer(customerId);
	}

	public List<Customer> readAllCustomer() {
		return customerDao.readAllCustomer();
	}

}
