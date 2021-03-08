package com.web.school.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.service.StudentService;
import com.web.school.project.service.SubjectService;

@Controller
@RequestMapping("api/people/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/")
	public String readAll(Model model) {
		List<Student> findAll = studentService.findByAll();
		
		model.addAttribute("findAll", findAll);
		return "views/students";
	}
	
	@GetMapping("/register")
	public String preRegister(Model model) {
		List<Subject> allSubjects = subjectService.findAll();
		model.addAttribute("title", "REGISTER STUDENT");
		model.addAttribute("subjects", allSubjects);
		model.addAttribute("student", new Student());
		return "views/register";		
	}
	
	@PostMapping("/postRegister")
	public String postRegister(@Valid Student student,BindingResult result,Model model, 
			@RequestParam List<String> subjectValues) {
		if (result.hasErrors()) {
			List<Subject> allSubjects = subjectService.findAll();
			model.addAttribute("title", "REGISTER STUDENT");
			model.addAttribute("subjects", allSubjects);
			return "views/register";
		}
		studentService.save(student, subjectValues);
		return "redirect:/api/people/students/";
	}
	
	@GetMapping("/teachers/{id}")
	public String readAllTeachersByStudentId(@PathVariable Long id, Model model) {
		List<Teacher> allTeachers = studentService.teachersByStudent(id);
		
		model.addAttribute("findAll", allTeachers);
		
		return "views/teachers";
	}
	
	@GetMapping("/subjects/{id}")
	public String readAllSubjectsByStudentId(@PathVariable Long id, Model model) {
		List<Subject> allSubjects = studentService.findBySubjectsByStudent(id);
		
		model.addAttribute("findAll", allSubjects);
		
		return "views/subjects";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Optional<Student> studentFound = studentService.findById(id);
		if (!studentFound.isPresent()) {
			return "redirect:/api/people/students/";
		}
		String surname = studentFound.get().getSurname();
		String title = "UPDATE STUDENT " + surname.toUpperCase();
		List<Subject> allSubjects = subjectService.findAll();
		List<Subject> subjectsStudying = studentFound.get().getSubjects();
		model.addAttribute("subjects", allSubjects);
		model.addAttribute("subjectsStudying", subjectsStudying);
		model.addAttribute("title", title);
		model.addAttribute("student", studentFound.get());
		return "views/register";		
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