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
import com.web.school.project.service.SubjectService;

@Controller
@RequestMapping("api/people/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/")
	public String findAll(Model model) {
		List<Subject> findAll = subjectService.findAll();
		
		model.addAttribute("findAll", findAll);
		return "views/subjects";
	}
	
	@RequestMapping("/teacher/{id}")
	public String readAllStudentsByTeacherId(@PathVariable Long id, Model model) {
		List<Teacher> teacherBySubjectId = subjectService.findTeacherBySubjectId(id);
		
		model.addAttribute("findAll", teacherBySubjectId);		
		return "views/teachers";
	}
	
	@RequestMapping("/students/{id}")
	public String readAllSubjectsByTeacherId(@PathVariable Long id, Model model) {
		List<Student> allStudents = subjectService.findStudentsBySubjectId(id);
		
		model.addAttribute("findAll", allStudents);	
		return "views/students";
	}
}