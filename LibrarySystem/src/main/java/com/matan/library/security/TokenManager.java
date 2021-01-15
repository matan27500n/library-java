package com.matan.library.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matan.library.exceptions.NotExistException;
import com.matan.library.restController.AdminController;
import com.matan.library.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenManager {

	private List<String> tokens = new ArrayList<String>();

	@Autowired
	private HashMap<String, CustomSession> tokensInMemory;

	@Autowired
	private AdminController adminController;

	public String addToken(ClientService clientService) {
		String token = UUID.randomUUID().toString();
		tokens.add(token);
		tokensInMemory.put(token, new CustomSession(clientService, System.currentTimeMillis()));
		// System.out.println("tokensInMemory: " + tokensInMemory);
		return token;
	}

	public long getTimestamp(String token) {
		return tokensInMemory.getOrDefault(token, null).getDate();
	}

	public ClientService getClientService(String token) {
		return tokensInMemory.getOrDefault(token, null).getClientService();
	}

	public boolean isTokenExist(String token) throws NotExistException {
		for (Map.Entry<String, CustomSession> entry : tokensInMemory.entrySet()) {
			if (entry.getKey().equals(token)) {
				return true;
			}
		}
		throw new NotExistException("The token is not exists in the system");
	}

	public void removeToken(String token) {
		tokens.remove(token);
		tokensInMemory.remove(token);
	}
}
