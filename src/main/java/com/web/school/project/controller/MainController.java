package com.web.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Person;
import com.web.school.project.service.PersonService;

@Controller
@RequestMapping("api/all")
public class MainController {
	
	@Autowired
	private PersonService personService;
		
	@RequestMapping("/")
	public String readAll(Model model) {
		
		List<Person> findAll = personService.findAll();
		model.addAttribute("findAll", findAll);
		
		return "views/index";
	}
}