package com.matan.library.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.models.Book;
import com.matan.library.models.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
public class CustomerService extends ClientService {

	private int customerID;

	@Override
	public boolean login(String email, String password) throws NotAllowedException {
		if (customerRepository.findByEmailAndPassword(email, password) != null) {
			return true;
		}
		return false;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}

	public Book getOneBook(int id) {
		return bookRepository.getOne(id);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getCustomerBooks() {
		Customer customer = customerRepository.getOne(customerID);
		return customer.getBooks();
	}

	public Customer getOneCustomer(int id) {
		return customerRepository.getOne(id);
	}

	public void purchaseBook(Book book) {
		Customer customer = customerRepository.getOne(customerID);
		customer.addBook(book);
		updateCustomer(customer);
	}

	public void cancelPurchase(int id) {
		Customer customer = customerRepository.getOne(customerID);
		Book book = bookRepository.getOne(id);
		customer.deleteBook(book);
		updateCustomer(customer);
	}

	public int getCustomerIdByEmailAndPassword(String email, String password) {
		return customerRepository.findByEmailAndPassword(email, password).getId();
	}

}
