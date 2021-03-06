package com.web.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.service.TeacherService;

@Controller
@RequestMapping("api/people/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/")
	public String findAll(Model model) {
		List<Teacher> findAll = teacherService.findAll();
		
		model.addAttribute("findAll", findAll);
		return "views/teachers";
	}
	
	@RequestMapping("/students/{id}")
	public String readAllStudentsByTeacherId(@PathVariable Long id, Model model) {
		List<Student> allStudents = teacherService.findStudentsByTeacherId(id);
		
		model.addAttribute("findAll", allStudents);
		
		return "views/students";
	}
	
	@RequestMapping("/subjects/{id}")
	public String readAllSubjectsByTeacherId(@PathVariable Long id, Model model) {
		List<Subject> allSubjects = teacherService.findSubjectsByTeacherId(id);
		
		model.addAttribute("findAll", allSubjects);
		
		return "views/subjects";
	}
}