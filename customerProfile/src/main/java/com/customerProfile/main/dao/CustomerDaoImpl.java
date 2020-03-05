package com.customerProfile.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.customerProfile.main.beans.Customer;

@Component
@Qualifier("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addCustomer(Customer customer) {
		jdbcTemplate.update(
				"INSERT INTO tbl_customers (customerId, first_name, last_name, gender,dob,door_no,block_no,house_no,street_name,area,city,pincode,created_at,updated_at) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getGender(),
				customer.getDob(), customer.getStreetName(),customer.getArea(),customer.getCity(),customer.getPincode(),customer.getCreatedAt(),customer.getUpdatedAt());
		System.out.println("Customer Added!!");
		System.out.println(customer);
	}

	@Override
	public void editCustomer(Customer customer, long customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer readCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> readAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
}
