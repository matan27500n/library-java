package com.matan.library.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Book> books;

	public void addBook(Book book) {
		books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	public Author(String firstName, String lastName, String email, String password) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.password = password;
	}
}
