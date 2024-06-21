package com.upload.file.s3.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.file.s3.entity.Todo;
import com.upload.file.s3.service.TodoService;

@RestController
@RequestMapping("api/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	public ResponseEntity<List<Todo>> getTodos() {

		return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE, 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> saveTodo(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
		return new ResponseEntity<>(todoService.saveTodo(title, description, file), HttpStatus.OK);
	}

	@GetMapping("{id}/image/download")
	public byte[] downloadTodoImage(@PathVariable("id") Long id) {
		return todoService.downloadTodoImage(id);

	}
}
