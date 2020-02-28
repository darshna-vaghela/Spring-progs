package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.CustomerEntity;

public interface CustomerRepository 
        extends JpaRepository<CustomerEntity, Integer> {
 
}