package com.raghav.springBoot.SpringBootDemo.userService;

import java.util.List;

import com.raghav.springBoot.SpringBootDemo.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User saveUser(User user);
	
	public User deleteUser(int id);
	
	public User updateUser(User user);
}
