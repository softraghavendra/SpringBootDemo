package com.raghav.springBoot.SpringBootDemo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raghav.springBoot.SpringBootDemo.exception.UserNotFoundException;
import com.raghav.springBoot.SpringBootDemo.model.User;
import com.raghav.springBoot.SpringBootDemo.userService.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping(path = "/test")
	public void m1(){
		System.out.println("m1 method called !!!");
	}
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(path ="/users/{id}")
	public User getUser(@PathVariable int id){
		User user = userService.getUser(id);
		if( user != null)
			return user;
		else throw new UserNotFoundException(" user not found id - " + id);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userService.saveUser(user);
		
		// ServletUriComponentBuilder is used for making uri
		// fromCurrentRequest is current url
		// path method is for appending String to the current url path
		// buildAndExpand is for replacing path method String id to current saved user id
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path ="/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userService.deleteUser(id);
		if(user == null)
			throw new UserNotFoundException("user is not found id - " + id);
	}
	
	@PutMapping(path = "/users")
	public User updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		if(updatedUser !=null)
			return updatedUser;
		else throw new UserNotFoundException("user is not found id - " + user.getId());
		
	}
	
}

