package com.customerProfile.main.services;

import java.util.List;

import com.customerProfile.main.beans.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	
	public void editCustomer(Customer customer,long customerId);
	
	public void deleteCustomer(long customerId);
	
	public Customer readCustomer(long customerId);
	
	public List<Customer> readAllCustomer();
		
}
