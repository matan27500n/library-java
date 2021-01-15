package com.matan.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.matan.library.exceptions.LoginException;
import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.service.AdminService;
import com.matan.library.service.AuthorService;
import com.matan.library.service.CustomerService;

@Service
@Lazy
public class LoginManager {

	@Autowired
	private ApplicationContext ctx;

	private AdminService adminService;

	private AuthorService authorService;

	private CustomerService customerService;

	@Autowired
	TokenManager tokenManager;

	public String login2(String email, String password, ClientType clientType)
			throws LoginException, NotAllowedException {
		switch (clientType) {
		case Admin:
			adminService = ctx.getBean(AdminService.class);
			if (adminService.login(email, password)) {
				return tokenManager.addToken(adminService);
			}
		case Author:
			authorService = ctx.getBean(AuthorService.class);
			if (authorService.login(email, password)) {
				int authorID = authorService.getAuthorIdByEmailAndPassword(email, password);
				authorService.setAuthorID(authorID);
				System.out.println(authorID);
				return tokenManager.addToken(authorService);
			}
		case Customer:
			customerService = ctx.getBean(CustomerService.class);
			if (customerService.login(email, password)) {
				int customerID = customerService.getCustomerIdByEmailAndPassword(email, password);
				customerService.setCustomerID(customerID);
				return tokenManager.addToken(customerService);
			}

		default:
			throw new LoginException("Invalid user or password or type");
		}
	}
}
