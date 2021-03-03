package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Subject;

public interface SubjectService {

	List<Subject> findAll();

	Optional<Subject> findById(Long id);

	Optional<Subject> findByName(String subject);

	List<Subject> findByTeacherId(Long id);

	List<Subject> findByStudentsId(Long id);
	
}