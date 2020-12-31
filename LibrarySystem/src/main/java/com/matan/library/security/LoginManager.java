package com.matan.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.matan.library.exceptions.LoginException;
import com.matan.library.service.AdminService;

@Service
@Lazy
public class LoginManager {

	@Autowired
	private ApplicationContext ctx;

	// @Autowired
	private AdminService adminService;

	@Autowired
	TokenManager tokenManager;

	public String login2(String email, String password, ClientType clientType) throws LoginException {
		switch (clientType) {
		case Admin:
			adminService = ctx.getBean(AdminService.class);
			if (adminService.login(email, password)) {
				return tokenManager.addToken(adminService);
			}
		default:
			throw new LoginException("Invalid user or password or type");
		}
	}
}
