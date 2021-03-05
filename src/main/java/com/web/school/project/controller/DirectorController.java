package com.web.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.school.project.domain.Director;
import com.web.school.project.service.DirectorService;

@Controller
@RequestMapping("api/people/directors")
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
	@RequestMapping("/")
	public String findAll(Model model) {
		List<Director> findAll = directorService.findAll();
		
		model.addAttribute("findAll", findAll);
		return "views/directors";
	}
}