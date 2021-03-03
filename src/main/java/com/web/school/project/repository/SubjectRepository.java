package com.web.school.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	Optional<Subject> findByName(String subject);

	List<Subject> findByTeacherId(Long id);

	List<Subject> findByStudentsId(Long id);
	
}