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

	public void addBook(Book book) {
		bookRepository.save(book);
		Author author = authorRepository.getOne(authorID);
		author.addBook(book);
	}

	public void updateBook(Book book) {
		bookRepository.saveAndFlush(book);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public Book getOneBook(int id) {
		return bookRepository.getOne(id);
	}

	public List<Book> getAllBooks() {
		Author author = authorRepository.getOne(authorID);
		return author.getBooks();
	}

	public int getCompanyIdByEmailAndPassword(String email, String password) {
		return authorRepository.findByEmailAndPassword(email, password).getId();
	}

}
