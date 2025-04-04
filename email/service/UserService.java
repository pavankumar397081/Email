package com.remit.email.service;

import java.util.List;

import com.remit.email.model.User;
/**
 * UserService
 */
public interface UserService {

	public List<User> getUser();
	public User getUserById(int id);
	public void addUser(User userData);
	public void updateUser(User userData);
	public void deleteById(int id);
}
