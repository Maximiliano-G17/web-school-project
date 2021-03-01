package com.web.school.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.school.project.domain.Student;
import com.web.school.project.repository.StudentRepository;
import com.web.school.project.service.StudentService;

@Service
@Transactional
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

	@Override
	public List<Student> findByYearStudied(String year) {
		return studentRepo.findByYearStudied(year);
	}

	@Override
	public List<Student> findByAddressContaining(String address) {
		return studentRepo.findByAddressContaining(address);
	}

	@Override
	public Optional<Student> findByDni(String dni) {
		return studentRepo.findByDni(dni);
	}

	@Override
	public List<Student> findByAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}
	
	@Override
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}