package com.matan.library.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.matan.library.models.Customer;
import com.matan.library.service.CustomerService;

@Component
@Order(3)
public class CustomerTest1 implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer("Topaz", "Levi", "topaz@gmail.com", "1234");
		customerService.addCustomer(customer);

		Customer customer2 = new Customer("Yael", "Eyal", "yael@gmail.com", "1234");
		customerService.addCustomer(customer2);

	}

}
