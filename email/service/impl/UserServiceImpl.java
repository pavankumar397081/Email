package com.remit.email.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remit.email.mapper.UserMapper;
import com.remit.email.model.User;
import com.remit.email.repository.UserRepo;
import com.remit.email.service.UserService;

/**
 * UserService
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo repo;
	
	UserMapper userMapper = UserMapper.INSTANCE;

	/**
	 * 
	 * @return List<User
	 */
	@Override
	public List<User> getUser() {
		return repo.findAll().stream().map(entityUser -> userMapper.toDTO(entityUser)).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public User getUserById(int id) {
		return  userMapper.toDTO(repo.findById(id).get());
	}

	/**
	 * 
	 * @param userData
	 */
	@Override
	public void addUser(User userData) {
		repo.save(userMapper.toEntity(userData));
	}

	/**
	 * 
	 * @param userData
	 */
	@Override
	public void updateUser(User userData) {
		repo.save(userMapper.toEntity(userData));
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
