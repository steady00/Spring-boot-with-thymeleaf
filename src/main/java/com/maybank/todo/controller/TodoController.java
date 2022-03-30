package com.maybank.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maybank.todo.entity.Todo;
import com.maybank.todo.entity.TodoRepository;
import com.maybank.todo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/list-all")
	public String listAll(Model model) {
		System.out.println("DATA" + todoService.listAll());
		model.addAttribute("todos", todoService.listAll()); // menampilkan data dari database
		return "todo/listAll";
	}
	
	@GetMapping("/input")
	public String input(Model model) {
		model.addAttribute("todo", new Todo());
		return "todo/listAdd";
	}
	
	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		//model.addAttribute("todos", todoService.get(id));
		model.addAttribute("todo", todoService.get(id));
		return "todo/listEdit";
	}
	
	
	@PostMapping("save")
	public String save(@ModelAttribute Todo todo) {
		todoService.saveTodo(todo);
		return "redirect:list-all";
	}
	
	
	@PostMapping("update")
	public String update(@ModelAttribute Todo todo) {
		todoService.updateTodo(todo);
		return "redirect:list-all";
	}
	
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		todoService.deleteTodo(id);
		return "redirect:../list-all";
	}
}
