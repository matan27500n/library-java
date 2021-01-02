package com.matan.library.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.models.Category;
import com.matan.library.service.AdminService;
import com.matan.library.service.AuthorService;

@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {
		Author author = new Author();
		author.setFirstName("Lidor");
		author.setLastName("Mualem");
		author.setEmail("lidor@gmail.com");
		author.setPassword("1234");
		adminService.addAuthor(author);

		Book book = new Book();
		book.setName("SpongeBob");
		book.setCategory(Category.Comedy);
		book.setPrice(50);
		book.setImage("https://images-na.ssl-images-amazon.com/images/I/71GA+b7Nz7L.jpg");
		authorService.setAuthorID(author.getId());
		authorService.addBook(book);
	}

}
