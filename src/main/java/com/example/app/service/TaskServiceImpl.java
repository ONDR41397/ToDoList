package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.TaskDao;
import com.example.app.domain.Task;

@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDao taskDao;

	@Override
	public List<Task> getTaskList() throws Exception {
		return taskDao.selectAll();
	}

	@Override
	public Task getTaskById(Integer id) throws Exception {
		return taskDao.selectById(id);
	}

	@Override
	public void addTask(Task task) throws Exception {
		taskDao.insert(task);
	}

	@Override
	public void editTask(Task task) throws Exception {
		taskDao.update(task);
	}

	@Override
	public void deleteTask(Integer id) throws Exception {
		taskDao.delete(id);
	}
}
