package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Task;

@Mapper
public interface TaskDao {
	
	List<Task> selectAll() throws Exception;
	
	Task selectById(Integer id) throws Exception;
	
	void insert(Task task) throws Exception;
	
	void update(Task task) throws Exception;
	
	void delete(Integer id) throws Exception;

}
