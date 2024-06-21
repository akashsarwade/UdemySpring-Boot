package com.upload.file.s3.repository;

import org.springframework.data.repository.CrudRepository;

import com.upload.file.s3.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {

	Todo findByTitle(String title);
	
}
