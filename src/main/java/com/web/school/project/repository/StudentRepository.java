package com.web.school.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Optional<Student> findBySurname(String surname);

	List<Student> findByYearStudied(String year);
	
	List<Student> findByAddressContaining(String address);

	Optional<Student> findByDni(String dni);
	
	@Query(value ="select s.teachers from Student s where s.id = :id")
	List<Teacher> teachersByStudent(Long id);

	@Query(value ="select s.subjects from Student s where s.id = :id")
	List<Subject> findBySubjectsByStudent(Long id);
}
