package com.web.school.project.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.web.school.project.domain.Person;
import com.web.school.project.repository.PersonRepository;
import com.web.school.project.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepo;
	
	@Override
	public List<Person> findAll() {
		return personRepo.findAll();
	}

	@Override
	public Page<Person> findPaginated(Map<String, Object> params) {
		int page;
		if(params.get("page") != null) {
			page = Integer.valueOf(params.get("page").toString()) - 1;
		}else {
			page = 0;
		}		
		PageRequest pageable = PageRequest.of(page, 5);
		return personRepo.findAll(pageable);
	}
}