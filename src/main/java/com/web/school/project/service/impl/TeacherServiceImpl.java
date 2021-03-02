package com.web.school.project.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.school.project.domain.Student;
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
//		Long ids = 11L;
//		Optional<Teacher> teacherFound = teacherRepo.findById(ids);
//		
//		System.out.println(teacherFound.get().getStudents().get(0).getName());
		return teacherRepo.findById(id);
	}

	@Override
	public List<Teacher> findBySpecialty(String specialty) {
		return teacherRepo.findBySpecialty(specialty);
	}

	@Override
	public List<Student> findStudentsById(Long id) {
		List<Student> studentsFound = teacherRepo.findStudentsById(id);
		studentsFound.forEach(x -> System.out.println(x));
		return studentsFound;
	}
}