package com.web.school.project.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.school.project.domain.Person;
import com.web.school.project.service.PersonService;

@Controller
@RequestMapping("api/people")
public class MainController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String readAll(@RequestParam Map<String, Object> params, Model model) {
		Page<Person> pagePeople = personService.findPaginated(params);		
		int totalPage = pagePeople.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}		
		model.addAttribute("list", pagePeople.getContent());
		return "views/index";
	}
	
	@GetMapping("/error403")
	public String error403() {		
		return "views/error403";
	}
}