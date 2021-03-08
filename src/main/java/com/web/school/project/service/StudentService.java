package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;

public interface StudentService {
		
	Optional<Student> findById(Long id);
	
	List<Student> findByAll();
	
	Student save(Student student,List<String> subjectValues);
	
	void delete(Long id);
	
	Optional<Student> findBySurname(String surname);

	List<Student> findByYearStudied(String year);

	List<Student> findByAddressContaining(String address);

	Optional<Student> findByDni(String dni);
	
	List<Teacher> teachersByStudent(Long id);

	List<Subject> findBySubjectsByStudent(Long id);
}