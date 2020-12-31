package com.matan.library.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.service.AdminService;

@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

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
		book.setDescription(
				"SpongeBob SquarePants is an American animated comedy television series created by marine science educator and animator Stephen Hillenburg for Nickelodeon. The series chronicles the adventures and endeavors of the title character and his aquatic friends in the fictional underwater city of Bikini Bottom. The fifth-longest-running American animated series, its popularity has made it a media franchise. It is the highest rated series to air on Nickelodeon and ViacomCBS Domestic Media Networks' most distributed property. The media franchise has generated more than $13 billion in merchandising revenue for Nickelodeon.");
		book.setPrice(50);
		book.setImage("https://images-na.ssl-images-amazon.com/images/I/71GA+b7Nz7L.jpg");
		adminService.addBook(book);
	}

}
