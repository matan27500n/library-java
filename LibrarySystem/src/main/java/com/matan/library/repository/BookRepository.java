package com.matan.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matan.library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
