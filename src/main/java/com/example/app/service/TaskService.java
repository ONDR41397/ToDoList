package com.example.app.service;

import java.util.List;

import com.example.app.domain.Task;

public interface TaskService {

	List<Task> getTaskList() throws Exception;
	
	Task getTaskById(Integer id) throws Exception;
	
	void addTask(Task task) throws Exception;
	
	void editTask(Task task) throws Exception;
	
	void deleteTask(Integer id) throws Exception;
	 
}
