package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Student;

public interface StudentService {
		
	Optional<Student> findById(Long id);
	
	Optional<Student> findBySurname(String surname);

	List<Student> findByYearStudied(String year);

	List<Student> findByAddressContaining(String address);

	Optional<Student> findByDni(String dni);

	List<Student> findByAll();
	
	Student save(Student student);
	
	void delete(Long id);
}