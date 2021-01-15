package com.matan.library.clr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.models.Category;
import com.matan.library.models.Customer;
import com.matan.library.service.AdminService;
import com.matan.library.service.AuthorService;
import com.matan.library.service.CustomerService;

@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Author author = new Author("Lidor", "Mualem", "lidor@gmail.com", "1234");
		adminService.addAuthor(author);

		Book book = new Book("SpongeBob", Category.Comedy, 50,
				"https://images-na.ssl-images-amazon.com/images/I/71GA+b7Nz7L.jpg");
		authorService.setAuthorID(author.getId());
		authorService.addBook(book);
		books.add(book);

		Book book2 = new Book("Harry Potter", Category.Drama, 100,
				"https://m.media-amazon.com/images/M/MV5BMGVmMWNiMDktYjQ0Mi00MWIxLTk0N2UtN2ZlYTdkN2IzNDNlXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_.jpg");
		authorService.setAuthorID(author.getId());
		authorService.addBook(book2);
		books.add(book2);
		author.setBooks(books);
		authorService.updateAuthor(author);

		System.out.println("author books " + author.getBooks());
		System.out.println(adminService.getAllBooks());

		Customer customer = new Customer("Topaz", "Dali", "topaz@gmail.com", "1234");
		customerService.addCustomer(customer);
	}

}
