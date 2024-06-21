package com.upload.file.s3.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//
//@Data annotation generates getters, setters, toString and equals methods for the Todo class.
//@AllArgsConstructor annotation generates a constructor with all the arguments for the Todo class.
//@NoArgsConstructor annotation generates a constructor with no arguments for the Todo class.
//@Builder annotation creates a builder pattern for the Todo class.
//@Entity annotation makes the Todo class a database entity.
//@Id annotation marks the id field as a primary key in the database.
//@GeneratedValue annotation makes the id field auto-increment whenever a new todo is saved into the database.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String imagePath;
	private String imageFileName;

}
