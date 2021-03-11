package com.web.school.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.repository.SubjectRepository;
import com.web.school.project.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepo;

	@Override
	public List<Subject> findAll() {
		return subjectRepo.findAll();
	}

	@Override
	public Optional<Subject> findById(Long id) {
		return subjectRepo.findById(id);
	}

	@Override
	public Optional<Subject> findByName(String subject) {
		return subjectRepo.findByName(subject);
	}

	@Override
	public List<Teacher> findTeacherBySubjectId(Long id) {
		return subjectRepo.findTeacherBySubjectId(id);
	}

	@Override
	public List<Student> findStudentsBySubjectId(Long id) {
		return subjectRepo.findStudentsBySubjectId(id);
	}	
}