package com.web.school.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	List<Teacher> findBySpecialty(String specialty);

	@Query(value ="select s from Teacher t join t.students s where t.id = :id")
	List<Student> findStudentsById(Long id);

}
