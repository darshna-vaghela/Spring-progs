package com.customerProfile.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerProfile.main.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}