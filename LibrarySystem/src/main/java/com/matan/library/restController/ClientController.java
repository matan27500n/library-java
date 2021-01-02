package com.matan.library.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.matan.library.exceptions.LoginException;
import com.matan.library.service.AdminService;
import com.matan.library.service.AuthorService;
import com.matan.library.service.CustomerService;

public abstract class ClientController {

	@Autowired
	protected AdminService adminService;

	@Autowired
	protected AuthorService authorService;

	@Autowired
	protected CustomerService customerService;

	public abstract ResponseEntity<?> login(String email, String password) throws LoginException;
}
