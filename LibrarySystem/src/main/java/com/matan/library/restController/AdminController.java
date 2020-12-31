package com.matan.library.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matan.library.exceptions.LoginException;
import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.security.ClientType;
import com.matan.library.security.LoginManager;
import com.matan.library.security.LoginResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("admin")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@Getter
public class AdminController extends ClientController {

	private String token;

	@Autowired
	private LoginManager loginManager;

	@PostMapping("addAuthor")
	public ResponseEntity<?> addAuthor(@RequestBody Author author) {
		adminService.addAuthor(author);
		return new ResponseEntity<Author>(HttpStatus.CREATED);
	}

	@PostMapping("login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password) throws LoginException {
		try {
			token = loginManager.login2(email, password, ClientType.Admin);
			System.out.println("token: " + token);
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setToken(token);
			loginResponse.setType(ClientType.Admin);
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.CREATED);

		} catch (LoginException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("getOneBook/{id}")
	public ResponseEntity<?> getOneBook(@PathVariable int id) {
		return new ResponseEntity<Book>(adminService.getOneBook(id), HttpStatus.OK);
	}
}
