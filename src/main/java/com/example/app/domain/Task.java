package com.example.app.domain;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Task {

	private Integer id;
	
	@NotBlank
	@Size(max=20)
	private String title;
	
	@Size(max=100)
	private String content;
	
	private Date dueDate = new Date();
	
	private Date created;
}
