package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Teacher;


public interface TeacherService {

	List<Teacher> findAll();

	Optional<Teacher> findById(Long id);

	List<Teacher> findBySpecialty(String specialty);

	List<Student> findStudentsById(Long id);

}
