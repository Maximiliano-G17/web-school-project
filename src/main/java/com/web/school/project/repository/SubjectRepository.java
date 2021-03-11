package com.web.school.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	Optional<Subject> findByName(String subject);
	
	@Query(value ="select s.teacher from Subject s where s.id = :id")
	List<Teacher> findTeacherBySubjectId(Long id);
	
	@Query(value ="select s.students from Subject s where s.id = :id")
	List<Student> findStudentsBySubjectId(Long id);
}