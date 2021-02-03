package com.matan.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.models.Customer;

@Service
public class AdminService extends ClientService {

	public boolean login(String email, String password) {
		return email.equals("admin@admin.com") && password.equals("admin");
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public void updateAuthor(Author author) {
		authorRepository.saveAndFlush(author);
	}

	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}

	public Author getOneAuthor(int id) {
		return authorRepository.getOne(id);
	}

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public Book getOneBook(int id) {
		return bookRepository.getOne(id);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

	public Customer getOneCustomer(int id) {
		return customerRepository.getOne(id);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
