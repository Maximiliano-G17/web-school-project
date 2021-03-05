package com.web.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Student;
import com.web.school.project.service.StudentService;

@Controller
@RequestMapping("api/people/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String findAll(Model model) {
		List<Student> findAll = studentService.findByAll();
		
		model.addAttribute("findAll", findAll);
		return "views/students";
	}
}