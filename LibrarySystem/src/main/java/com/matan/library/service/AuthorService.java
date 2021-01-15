package com.matan.library.service;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.matan.library.exceptions.NotAllowedException;
import com.matan.library.models.Author;
import com.matan.library.models.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
public class AuthorService extends ClientService {

	private int authorID;

	@Override
	public boolean login(String email, String password) throws NotAllowedException {
		if (authorRepository.findByEmailAndPassword(email, password) != null) {
			return true;
		}
		return false;
	}

	public void updateAuthor(Author author) {
		authorRepository.saveAndFlush(author);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
		Author author = authorRepository.getOne(authorID);
		author.addBook(book);
		updateAuthor(author);
	}

	public void updateBook(Book book) {
		bookRepository.saveAndFlush(book);
	}

	public void deleteBook(int id) {
		Author author = authorRepository.getOne(authorID);
		author.removeBook(bookRepository.getOne(id));
		bookRepository.deleteById(id);
		System.out.println("delete successfully");
		updateAuthor(author);
	}

	public Book getOneBook(int id) {
		return bookRepository.getOne(id);
	}

	public List<Book> getAllBooks(int id) {
		authorID = id;
		Author author = authorRepository.getOne(authorID);
		return author.getBooks();
	}

	public int getAuthorIdByEmailAndPassword(String email, String password) {
		return authorRepository.findByEmailAndPassword(email, password).getId();
	}

}
