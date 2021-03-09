package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;

public interface SubjectService {

	List<Subject> findAll();

	Optional<Subject> findById(Long id);

	Optional<Subject> findByName(String subject);

	Teacher findTeacherBySubjectId(Long id);

	List<Student> findStudentsBySubjectId(Long id);
	
}