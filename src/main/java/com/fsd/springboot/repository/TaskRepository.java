package com.fsd.springboot.repository;

import java.util.List;

import com.fsd.springboot.model.Task;

public interface TaskRepository {

	void persist(Task task);
	List<Task> getAllTasks();
	void updateTask(Task task);
	//void deleteUser(int user_ID);
}
