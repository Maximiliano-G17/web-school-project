package com.web.school.project.service;

import java.util.Optional;

import com.web.school.project.domain.Student;

public interface StudentService {
		
	Optional<Student> findById(Long id);
	
	Optional<Student> findBySurname(String surname);

}