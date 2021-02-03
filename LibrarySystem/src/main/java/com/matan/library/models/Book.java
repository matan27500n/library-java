package com.matan.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Category category;
	private double price;
	private int amount;
	@Column(length = 100000)
	private String summary;
	@Column(length = 100000)
	private String image;

	public Book(String name, Category category, double price, int amount, String summary, String image) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.amount = amount;
		this.summary = summary;
		this.image = image;
	}

}
