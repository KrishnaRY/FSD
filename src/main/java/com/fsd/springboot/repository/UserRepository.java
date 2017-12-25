package com.fsd.springboot.repository;

import java.util.List;

import com.fsd.springboot.model.User;

public interface UserRepository {

	void persist(User user);
	List<User> getAllUsers();
	void updateUser(User user);
	void deleteUser(int user_ID);
}
