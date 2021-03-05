package com.web.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Subject;
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
}