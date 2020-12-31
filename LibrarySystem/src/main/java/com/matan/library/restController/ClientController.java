package com.matan.library.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.matan.library.exceptions.LoginException;
import com.matan.library.service.AdminService;

public abstract class ClientController {

	@Autowired
	protected AdminService adminService;

	public abstract ResponseEntity<?> login(String email, String password) throws LoginException;
}
