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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matan.library.exceptions.LoginException;
import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.models.Book;
import com.matan.library.models.Customer;
import com.matan.library.security.ClientType;
import com.matan.library.security.LoginManager;
import com.matan.library.security.LoginResponse;
import com.matan.library.security.TokenManager;

import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("customer")
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@Getter
public class CustomerController extends ClientController {

	private String token;

	@Autowired
	private LoginManager loginManager;

	@Autowired
	private TokenManager tokenManager;

	@PostMapping("login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password) throws LoginException {
		try {
			token = loginManager.login2(email, password, ClientType.Customer);
			System.out.println("token: " + token);
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setToken(token);
			loginResponse.setType(ClientType.Customer);
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

	@GetMapping("getOneCustomer/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(customerService.getOneCustomer(id), HttpStatus.OK);
	}

	@PostMapping("purchaseBook")
	public ResponseEntity<?> purchaseBook(@RequestBody Book book) {
		customerService.purchaseBook(book);
		return new ResponseEntity<Book>(HttpStatus.CREATED);
	}

	@DeleteMapping("cancelPurchase")
	public ResponseEntity<?> cancelPurchase(@RequestBody Book book) {
		customerService.cancelPurchase(book);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("getOneBook/{id}")
	public ResponseEntity<?> getOneBook(@PathVariable int id) {
		return new ResponseEntity<Book>(customerService.getOneBook(id), HttpStatus.OK);
	}

	@GetMapping("getAllBooks")
	public ResponseEntity<?> getAllBooks() {
		return new ResponseEntity<List<Book>>(customerService.getAllBooks(), HttpStatus.OK);
	}

}
