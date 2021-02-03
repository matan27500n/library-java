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
@Order(1)
public class AuthorTest1 implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();
		Author author = new Author("Lidor", "Mualem", "lidor@gmail.com", "1234");
		adminService.addAuthor(author);

		String summaryBook = "SpongeBob SquarePants is an American animated comedy television series created by marine science educator and animator Stephen Hillenburg for Nickelodeon. The series chronicles the adventures and endeavors of the title character and his aquatic friends in the fictional underwater city of Bikini Bottom. The fifth-longest-running American animated series, its popularity has made it a media franchise. It is the highest rated series to air on Nickelodeon and it is the most distributed property from ViacomCBS Networks International. The media franchise has generated more than $13 billion in merchandising revenue for Nickelodeon.";
		Book book = new Book("SpongeBob", Category.Comedy, 50, 35, summaryBook,
				"https://images-na.ssl-images-amazon.com/images/I/71GA+b7Nz7L.jpg");
		authorService.setAuthorID(author.getId());
		authorService.addBook(book);
		books.add(book);

		String summaryBook2 = "Harry Potter is a series of seven fantasy novels written by British author, J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harry's struggle against Lord Voldemort, a dark wizard who intends to become immortal, overthrow the wizard governing body known as the Ministry of Magic and subjugate all wizards and Muggles ";
		Book book2 = new Book("Harry Potter", Category.Drama, 100, 20, summaryBook2,
				"https://m.media-amazon.com/images/M/MV5BMGVmMWNiMDktYjQ0Mi00MWIxLTk0N2UtN2ZlYTdkN2IzNDNlXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_.jpg");
		authorService.setAuthorID(author.getId());
		authorService.addBook(book2);
		books.add(book2);

		String summaryBook3 = "Dora the Explorer is an American children's animated television series and Multimedia franchise created by Chris Gifford, Valerie Walsh Valdes and Eric Weiner that premiered on Nickelodeon on August 14, 2000. The series is produced by Nickelodeon Animation Studio. The series centers around Dora Marquez, a seven-year-old Latina girl, with a love of embarking on quests related to an activity that she wants to partake of or a place that she wants to go to, accompanied by her talking purple backpack and anthropomorphic monkey companion named Boots (named for his beloved pair of red boots).";
		String image3 = "https://i.pinimg.com/originals/9f/89/27/9f892759184b0290f74b25e77764512c.jpg";
		Book book3 = new Book("Dora the Explorer", Category.Comedy, 50, 31, summaryBook3, image3);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book3);
		books.add(book3);

		String summaryBook4 = "The Hunger Games film series is composed of science fiction dystopian adventure films, based on The Hunger Games trilogy of novels by the American author Suzanne Collins. The movies are distributed by Lionsgate and produced by Nina Jacobson and Jon Kilik. The series feature an ensemble cast including Jennifer Lawrence as Katniss Everdeen, Josh Hutcherson as Peeta Mellark, Liam Hemsworth as Gale Hawthorne, Woody Harrelson as Haymitch Abernathy, Elizabeth Banks as Effie Trinket, Stanley Tucci as Caesar Flickerman, and Donald Sutherland as President Snow.";
		String image4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAgcF7f-10fOeBwFEDI8SiLx0iOjdU1br_fw&usqp=CAU";
		Book book4 = new Book("The Hunger Games", Category.Horror, 130, 14, summaryBook4, image4);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book4);
		books.add(book4);

		String summaryBook5 = "To Kill a Mockingbird is a novel by the American author Harper Lee. It was published in 1960 and, instantly successful in the United States, it is widely read in high schools and middle schools. To Kill a Mockingbird has become a classic of modern American literature, winning the Pulitzer Prize. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was ten.";
		String image5 = "https://m.media-amazon.com/images/I/516IbJ592JL.jpg";
		Book book5 = new Book("To Kill a Mockingbird", Category.Drama, 85, 44, summaryBook5, image5);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book5);
		books.add(book5);

		String summaryBook6 = "Pride and Prejudice is an 1813 romantic novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness. Its humour lies in its honest depiction of manners, education, marriage, and money during the Regency era in Great Britain.\r\n"
				+ "\r\n"
				+ "Mr. Bennet of Longbourn estate has five daughters, but his property is entailed and can only be passed to a male heir. His wife also lacks an inheritance, so his family will be destitute upon his death. Thus, it is imperative that at least one of the girls marry well to support the others, which is a motivation that drives the plot. The novel revolves around the importance of marrying for love rather than money or social prestige, despite the communal pressure to make a wealthy match.";
		String image6 = "https://m.media-amazon.com/images/M/MV5BMTA1NDQ3NTcyOTNeQTJeQWpwZ15BbWU3MDA0MzA4MzE@._V1_.jpg";
		Book book6 = new Book("Pride and Prejudice", Category.Drama, 60, 30, summaryBook6, image6);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book6);
		books.add(book6);

		String summaryBook7 = "Wuthering Heights is an 1847 novel by Emily Brontë, published under the pseudonym Ellis Bell. It concerns two families of the landed gentry in the West Yorkshire moorlands, the Earnshaws and the Lintons, and their turbulent relationships with Earnshaw's adopted son, Heathcliff. It was influenced by Romanticism and Gothic fiction.\r\n"
				+ "\r\n"
				+ "Wuthering Heights is now considered a classic of English literature, but contemporaneous reviews were polarised. It was controversial for its depictions of mental and physical cruelty, and for its challenges to Victorian morality, and religious and societal values.[1][2]\r\n"
				+ "\r\n"
				+ "Wuthering Heights was accepted by publisher Thomas Newby along with Anne Brontë's Agnes Grey before the success of their sister Charlotte's novel Jane Eyre, but they were published later. Charlotte edited a second edition of Wuthering Heights after Emily's death which was published in 1850.[3] It has inspired an array of adaptations across several media, including a hit song.";
		String image7 = "https://d28hgpri8am2if.cloudfront.net/book_images/onix/cvr9781471137266/wuthering-heights-9781471137266_hr.jpg";
		Book book7 = new Book("Wuthering Heights", Category.Horror, 30, 70, summaryBook7, image7);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book7);
		books.add(book7);

		String summaryBook8 = "Crime and Punishment (pre-reform Russian: Преступленіе и наказаніе; post-reform Russian: Преступление и наказание, tr. Prestupléniye i nakazániye, IPA: [prʲɪstʊˈplʲenʲɪje ɪ nəkɐˈzanʲɪje]) is a novel by the Russian author Fyodor Dostoevsky. It was first published in the literary journal The Russian Messenger in twelve monthly installments during 1866.[1] It was later published in a single volume. It is the second of Dostoevsky's full-length novels following his return from ten years of exile in Siberia. Crime and Punishment is considered the first great novel of his \"mature\" period of writing.[2] The novel is often cited as one of the supreme achievements in literature.";
		String image8 = "https://images-na.ssl-images-amazon.com/images/I/71CcO-jvRUL.jpg";
		Book book8 = new Book("Crime and Punishment", Category.Action, 90, 70, summaryBook8, image8);
		authorService.setAuthorID(author.getId());
		authorService.addBook(book8);
		books.add(book8);

		author.setBooks(books);
		authorService.updateAuthor(author);

	}

}
