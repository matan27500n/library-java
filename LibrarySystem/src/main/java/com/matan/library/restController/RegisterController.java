package com.matan.library.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matan.library.models.Author;
import com.matan.library.models.Customer;
import com.matan.library.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RegisterController {

	@Autowired
	private AdminService adminService;

	@PostMapping("registerAuthor")
	public ResponseEntity<?> registerAuthor(@RequestBody Author author) {
		adminService.addAuthor(author);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("registerCustomer")
	public ResponseEntity<?> registerAuthor(@RequestBody Customer customer) {
		adminService.addCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
