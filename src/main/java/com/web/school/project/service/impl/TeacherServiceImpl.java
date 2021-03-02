package com.web.school.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.repository.TeacherRepository;
import com.web.school.project.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Override
	public List<Teacher> findAll() {
		return teacherRepo.findAll();
	}

	@Override
	public Optional<Teacher> findById(Long id) {
		return teacherRepo.findById(id);
	}

	@Override
	public List<Teacher> findBySpecialty(String specialty) {
		return teacherRepo.findBySpecialty(specialty);
	}

	@Override
	public List<Student> findStudentsByTeacherId(Long id) {
		return teacherRepo.findStudentsByTeacherId(id);
	}
	

	@Override
	public List<Subject> findSubjectsByTeacherId(Long id) {
		return teacherRepo.findSubjectsByTeacherId(id);
	}

	@Override
	public List<Teacher> findBySurname(String surname) {
		return teacherRepo.findBySurname(surname);
	}

	@Override
	public List<Teacher> findByAddressContaining(String address) {
		return teacherRepo.findByAddressContaining(address);
	}

	@Override
	public Optional<Teacher> findByDni(String dni) {
		return teacherRepo.findByDni(dni);
	}
}