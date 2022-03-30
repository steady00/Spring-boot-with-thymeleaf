package com.maybank.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.todo.entity.User;
import com.maybank.todo.entity.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	
}
