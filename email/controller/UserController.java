package com.remit.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remit.email.model.User;
import com.remit.email.service.UserService;

/**
 * UserController
 */
@RestController
@CrossOrigin
public class UserController {
	@Autowired
	UserService service;
	
	/**
	 * 
	 * @return  List<User>
	 */
	@GetMapping("user")
	public ResponseEntity<List<User>>  getUser() {
		return ResponseEntity.ok(service.getUser());

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return ResponseEntity.ok(service.getUserById(id));
	}

	/**
	 * 
	 * @param userData
	 */
	@PostMapping("user")
	public ResponseEntity<?> addUser(@RequestBody User userData) {
		service.addUser(userData);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}

	/**
	 * 
	 * @param userData
	 */
	@PutMapping("user")
	public ResponseEntity<?> updateUser(@RequestBody User userData) {
		service.updateUser(userData);
		return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
	}
	/**
	 * 
	 * @param id
	 */

	@DeleteMapping("user/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
