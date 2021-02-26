package com.web.school.project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.school.project.domain.Student;
import com.web.school.project.repository.StudentRepository;
import com.web.school.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Optional<Student> findById(Long id) {
		return studentRepo.findById(id);
	}

	@Override
	public Optional<Student> findBySurname(String surname) {
		return studentRepo.findBySurname(surname);
	}
}