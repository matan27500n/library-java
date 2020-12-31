package com.matan.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matan.library.models.Author;
import com.matan.library.models.Book;

@Service
public class AdminService extends ClientService {

	public boolean login(String email, String password) {
		if (authorRepository.findByEmailAndPassword(email, password) != null) {
			return true;
		}
		return false;
		// return email.equals("library@library.com") && password.equals("library");
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public void updateAuthor(Author author) {
		authorRepository.saveAndFlush(author);
	}

	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}

	public Author getOneAuthor(int id) {
		return authorRepository.getOne(id);
	}

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public Book getOneBook(int id) {
		return bookRepository.getOne(id);
	}

}
