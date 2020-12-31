package com.matan.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matan.library.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	Author findByEmailAndPassword(String email, String password);
}
