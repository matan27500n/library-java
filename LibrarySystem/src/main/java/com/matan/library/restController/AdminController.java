package com.matan.library.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matan.library.exceptions.LoginException;
import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.models.Customer;
import com.matan.library.security.ClientType;
import com.matan.library.security.LoginManager;
import com.matan.library.security.LoginResponse;
import com.matan.library.security.TokenManager;
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
	private TokenManager tokenManager;

	@Autowired
	private LoginManager loginManager;

	@PostMapping("login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password) throws LoginException {
		try {
			token = loginManager.login2(email, password, ClientType.Admin);
			// System.out.println("token: " + token);
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setToken(token);
			loginResponse.setType(ClientType.Admin);
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.CREATED);

		} catch (LoginException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (NotAllowedException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("logout")
	public ResponseEntity<?> logout() {
		tokenManager.removeToken(token);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("addAuthor")
	public ResponseEntity<?> addAuthor(@RequestBody Author author) {
		adminService.addAuthor(author);
		return new ResponseEntity<Author>(HttpStatus.CREATED);
	}

	@PutMapping("updateAuthor")
	public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
		adminService.updateAuthor(author);
		return new ResponseEntity<Author>(HttpStatus.OK);
	}

	@DeleteMapping("deleteAuthor/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
		adminService.deleteAuthor(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("getOneAuthor/{id}")
	public ResponseEntity<?> getOneAuthor(@PathVariable int id) {
		return new ResponseEntity<Author>(adminService.getOneAuthor(id), HttpStatus.OK);
	}

	@GetMapping("getAllAuthors")
	public ResponseEntity<?> getAllAuthors() {
		return new ResponseEntity<List<Author>>(adminService.getAllAuthors(), HttpStatus.OK);
	}

	@DeleteMapping("deleteBook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		adminService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("getOneBook/{id}")
	public ResponseEntity<?> getOneBook(@PathVariable int id) {
		return new ResponseEntity<Book>(adminService.getOneBook(id), HttpStatus.OK);
	}

	@GetMapping("getAllBooks")
	public ResponseEntity<?> getAllBooks() {
		return new ResponseEntity<List<Book>>(adminService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("getOneCustomer/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(adminService.getOneCustomer(id), HttpStatus.OK);
	}

	@GetMapping("getAllCustomers")
	public ResponseEntity<?> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(adminService.getAllCustomers(), HttpStatus.OK);
	}
}
