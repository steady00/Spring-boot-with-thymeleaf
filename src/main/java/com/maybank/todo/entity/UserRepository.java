package com.maybank.todo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
