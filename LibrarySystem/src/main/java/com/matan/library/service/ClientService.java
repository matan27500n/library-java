package com.matan.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.repository.AuthorRepository;
import com.matan.library.repository.BookRepository;
import com.matan.library.repository.CustomerRepository;

@Service
public abstract class ClientService {

	@Autowired
	protected AuthorRepository authorRepository;
	@Autowired
	protected BookRepository bookRepository;
	@Autowired
	protected CustomerRepository customerRepository;

	public abstract boolean login(String email, String password) throws NotAllowedException;
}
