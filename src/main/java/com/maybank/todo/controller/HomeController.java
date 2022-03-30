package com.maybank.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maybank.todo.entity.User;
import com.maybank.todo.entity.UserRepository;
import com.maybank.todo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired 
	UserService repo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		repo.saveUser(user);
		return "redirect:hello";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String masuk() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(){
		return "dashboard";
		
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hallo")
	public String hallo() {
		return "hallo";
	}
	
}
