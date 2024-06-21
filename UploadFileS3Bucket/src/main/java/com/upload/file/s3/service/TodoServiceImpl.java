package com.upload.file.s3.service;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

//import com.amazonaws.services.s3.model.MultipartUpload;
import com.upload.file.s3.entity.Todo;
import com.upload.file.s3.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final FileStoreService fileStoreService;
	private final TodoRepository todoRepository;

	@Override
	public Todo saveTodo(String title, String description, com.amazonaws.services.s3.model.MultipartUpload file) {

		// check if the file is empty

//		if(file.isEmpty()) {
//            throw new IllegalStateException("Cannot upload empty file");
//
//		}
//		
//        //Check if the file is an image
//
//		 if (!Arrays.asList(IMAGE_PNG.getMimeType(),
//	                IMAGE_BMP.getMimeType(),
//	                IMAGE_GIF.getMimeType(),
//	                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
//	            throw new IllegalStateException("FIle uploaded is not an image");
//	        }
//		 
//	        //get file metadata
//
//Map<String, String>metadata=new HashMap<>();
//metadata.put("Content-type",file.getC)

		return null;
	}

	// image download Implementation
	@Override
	public byte[] downloadTodoImage(Long Id) {
		Todo todo = todoRepository.findById(Id).get();
		return fileStoreService.download(todo.getImagePath(), todo.getImageFileName());
	}

	@Override
	public List<Todo> getAllTodos() {
		List<Todo> todos = new ArrayList<>();
		todoRepository.findAll().forEach(todos::add);
		return todos;
	}

}
