package com.web.school.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
