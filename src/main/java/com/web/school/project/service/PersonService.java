package com.web.school.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.web.school.project.domain.Person;

public interface PersonService {

	List<Person> findAll();
	
	Page<Person> findPaginated(Map<String, Object> params);

}