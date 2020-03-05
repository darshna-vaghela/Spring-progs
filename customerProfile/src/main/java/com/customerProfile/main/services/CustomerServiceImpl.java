package com.customerProfile.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerProfile.main.beans.Customer;
import com.customerProfile.main.dao.CustomerDao;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public void editCustomer(Customer customer, long customerId) {
		customerDao.editCustomer(customer, customerId);
	}

	public void deleteCustomer(long customerId) {
		customerDao.deleteCustomer(customerId);
	}

	public Customer readCustomer(long customerId) {
		return customerDao.readCustomer(customerId);
	}

	public List<Customer> readAllCustomer() {
		return customerDao.readAllCustomer();
	}

	
}
