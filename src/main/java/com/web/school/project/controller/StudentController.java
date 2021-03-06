package com.web.school.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.service.StudentService;

@Controller
@RequestMapping("api/people/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String readAll(Model model) {
		List<Student> findAll = studentService.findByAll();
		
		model.addAttribute("findAll", findAll);
		return "views/students";
	}
	
	@RequestMapping("/teachers/{id}")
	public String readAllTeachersByStudentId(@PathVariable Long id, Model model) {
		List<Teacher> allTeachers = studentService.teachersByStudent(id);
		
		model.addAttribute("findAll", allTeachers);
		
		return "views/teachers";
	}
	
	@RequestMapping("/subjects/{id}")
	public String readAllSubjectsByStudentId(@PathVariable Long id, Model model) {
		List<Subject> allSubjects = studentService.findBySubjectsByStudent(id);
		
		model.addAttribute("findAll", allSubjects);
		
		return "views/subjects";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Optional<Student> studentFound = studentService.findById(id);
		if (!studentFound.isPresent()) {
			return "redirect:/api/people/students/";
		}
		model.addAttribute("studentFound", studentFound.get());
		return "";		
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<Student> studentFound = studentService.findById(id);
		if (!studentFound.isPresent()) {
			return "redirect:/api/people/students/";
		}
		studentService.delete(id);
		return "redirect:/api/people/students/";		
	}
}