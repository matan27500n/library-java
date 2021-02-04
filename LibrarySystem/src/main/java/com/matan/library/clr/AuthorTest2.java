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

		String summary3 = "The legendary story of a resistance hero\r\n" + "\r\n"
				+ "'Full of death and excitement' - Sunday Times\r\n" + "\r\n" + "'Unique' - TLS\r\n" + "\r\n"
				+ "George Psychoundakis was a young shepherd boy who knew the island of Crete intimately when the Nazis invaded by air in 1941. He immediately joined the resistance and took on the crucial job of war-time runner.\r\n"
				+ "\r\n"
				+ "It was not only the toughest but the most dangerous job of all. It involved immense journeys carrying vital messages, smuggling arms and explosives and guiding Allied soldiers, agents and commandos through heavily garrisoned territory. And George did not escape capture and torture on his many forays.\r\n"
				+ "\r\n"
				+ "This brilliant account of George's activities across mountainous terrain, come blazing summer or freezing winter, is a gripping story of bravery against impossible odds.";
		String image3 = "https://www.penguin.co.uk/content/dam/prh/books/242/24290/9780141043340.jpg.transform/PRHDesktopWide_small/image.jpg";
		Book book3 = new Book("THE CRETAN RUNNER", Category.Action, 30, 70, summary3, image3);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book3);
		books.add(book3);

		String summary4 = "Adam Tooze's The Wages of Destruction: The Making and Breaking of the Nazi Economy provides a groundbreaking new account of how Hitler established himself in power, mobilized for war - and led his country to annihilation.\r\n"
				+ "\r\n"
				+ "Was the tragedy of the Second World War determined by Nazi Germany's terrifying power, or by its fatal weakness?\r\n"
				+ "\r\n"
				+ "This gripping and universally-acclaimed new history tells the real story of the cost of Hitler's plans for world domination - and will overturn everything you thought you knew about the Third Reich.\r\n"
				+ "\r\n" + "'A tour de force' Niall Ferguson\r\n" + "\r\n"
				+ "'Masterful ... smashes a gallery of preconceptions' The Times\r\n" + "\r\n"
				+ "'This book will change the way we look at Nazi history ... nothing less than a masterpiece. Rejoice, rejoice, for a great historian is born' Sunday Telegraph\r\n"
				+ "\r\n"
				+ "'A remarkable and gripping revision of the history of Nazi Germany' New Statesman Books of the Year\r\n"
				+ "\r\n" + "'A powerful and provocative reassessment of the whole story' Richard Overy";
		String image4 = "https://images-na.ssl-images-amazon.com/images/I/61RsLNTPW7L.jpg";
		Book book4 = new Book("The Wages of Destruction", Category.Drama, 70, 40, summary4, image4);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book4);
		books.add(book4);

		String summary5 = "A prominent Viennese psychiatrist before the war, Viktor Frankl was uniquely able to observe the way that he and other inmates coped with the experience of being in Auschwitz. He noticed that it was the men who comforted others and who gave away their last piece of bread who survived the longest - and who offered proof that everything can be taken away from us except the ability to choose our attitude in any given set of circumstances.\r\n"
				+ "\r\n"
				+ "The sort of person the prisoner became was the result of an inner decision and not of camp influences alone. Only those who allowed their inner hold on their moral and spiritual selves to subside eventually fell victim to the camp's degenerating influence - while those who made a victory of those experiences turned them into an inner triumph.\r\n"
				+ "\r\n"
				+ "Frankl came to believe that man's deepest desire is to search for meaning and purpose. This outstanding work offers us all a way to transcend suffering and find significance in the art of living.";
		String image5 = "https://images-na.ssl-images-amazon.com/images/I/61S26j0szkL.jpg";
		Book book5 = new Book("Man's Search For Meaning", Category.Drama, 100, 30, summary5, image5);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book5);
		books.add(book5);

		author.setBooks(books);
		authorService.updateAuthor(author);

	}

}
