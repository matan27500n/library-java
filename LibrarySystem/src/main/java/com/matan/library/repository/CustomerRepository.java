package com.matan.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matan.library.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
