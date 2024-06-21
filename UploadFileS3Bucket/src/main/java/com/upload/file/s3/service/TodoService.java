package com.upload.file.s3.service;

import java.util.List;

import com.amazonaws.services.s3.model.MultipartUpload;
import com.upload.file.s3.entity.Todo;

public interface TodoService {
	Todo saveTodo(String title, String description, MultipartUpload file);

	byte[] downloadTodoImage(Long id);

	List<Todo> getAllTodos();

}
