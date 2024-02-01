package com.example.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Task;
import com.example.app.service.TaskService;

import jakarta.validation.Valid;

@Controller
public class TaskController {

	@Autowired
	TaskService service;
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping("/menu")
	public String menu() throws Exception {
		return "menu";
	}

	@GetMapping("/regist")
	public String addGet(Model model) throws Exception {
		model.addAttribute("task", new Task());
		return "regist";
	}

	@PostMapping("/regist")
	public String addPost(@Valid Task task, Errors errors, Model model) throws Exception {

		if (errors.hasErrors()) {
			return "regist";
		}

		service.addTask(task);
		return "registComp";
	}

	@GetMapping("/detail")
	public String detail(Model model) throws Exception {
		model.addAttribute("tasks", service.getTaskList());
		return "detail";
	}

	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("task", service.getTaskById(id));
		return "edit";
	}

	@PostMapping("edit/{id}")
	public String editPost(@PathVariable Integer id, @Valid Task task, Errors errors) throws Exception {

		if (errors.hasErrors()) {
			return "regist";
		}

		service.editTask(task);
		return "editComp";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("task", service.getTaskById(id));
		service.deleteTask(id);
		return "deleteComp";
	}

	@GetMapping
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		// ログイン画面に戻るようにする
		// ログイン画面にlogoutした旨を表示する
		return "redirect:/";
	}
}
