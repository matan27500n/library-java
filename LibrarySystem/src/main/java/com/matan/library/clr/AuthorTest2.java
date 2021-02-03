package com.matan.library.clr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.matan.library.models.Author;
import com.matan.library.models.Book;
import com.matan.library.models.Category;
import com.matan.library.service.AdminService;
import com.matan.library.service.AuthorService;

@Component
@Order(2)
public class AuthorTest2 implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Author author = new Author("Yossi", "Choen", "yossi@gmail.com", "1234");
		adminService.addAuthor(author);

		String summary1 = "The Outsiders is a coming-of-age novel by S. E. Hinton, first published in 1967 by Viking Press. Hinton was 15 when she started writing the novel but did most of the work when she was 16 and a junior in high school.[1] Hinton was 18 when the book was published.[2] The book details the conflict between two rival gangs divided by their socioeconomic status: the working-class \"greasers\" and the upper-class \"Socs\" (pronounced /ˈsoʊʃɪz/—short for Socials). The story is told in first-person perspective by teenage protagonist Ponyboy Curtis.\r\n"
				+ "\r\n"
				+ "The story in the book takes place in Tulsa, Oklahoma, in 1965,[2] but this is never explicitly stated in the book.\r\n"
				+ "\r\n"
				+ "A film adaptation was produced in 1983, and a short-lived television series appeared in 1990, picking up where the movie left off. A stage adaptation was written by Christopher Sergel and published in 1990.";
		String image1 = "https://d1kvkzjpuym02z.cloudfront.net/56cb8b68e4b0d35629bb6171.jpeg?Expires=2014908479&Signature=REailcdoQ0nRb-RMYFK9lmOhghOQgqT8~gz53B9D~sIpasYOE~s3tfAJZNE~1fRpoCEnVT4Tt0Wbc0ZXF3XWObQbrw7gI~X7ARel5u6WVT5xaFhcvRezzOWOGxQlD~S4tchA79N10eYedSx7D0NgbIetdlDN~2H4XTkdC4XBeas_&Key-Pair-Id=APKAJXYWFXCDTRLR3EFA";
		Book book = new Book("The Outsiders", Category.Drama, 100, 50, summary1, image1);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book);
		books.add(book);

		String summary2 = "The book examines Martin's childhood, and his first jobs at the Southern California theme parks Disneyland and Knott's Berry Farm. It includes his later stand-up comedy career, which lasted until 1981. In that year, Martin retired from stand-up comedy, feeling that he had achieved as much as he could with it, that his routine had become bloated and old, and that he would rather pursue his burgeoning film career.\r\n"
				+ "\r\n"
				+ "Martin goes into detail about his act, including how others viewed his act, the tiny audiences he drew at the beginning of his career, and the huge shows performing in front of tens of thousands of fans at the height of his popularity. Through Martin's spare explanations, the reader comes to understand his love for magic, his early gags like the \"Happy Feet\", and his trademark three-piece white suit.";
		String image2 = "https://images-na.ssl-images-amazon.com/images/I/51uE7ekXM3L._SX324_BO1,204,203,200_.jpg";
		Book book2 = new Book("Born Standing Up", Category.Comedy, 25, 150, summary2, image2);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book2);
		books.add(book2);

		author.setBooks(books);
		authorService.updateAuthor(author);

	}

}
