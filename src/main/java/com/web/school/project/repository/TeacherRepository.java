package com.web.school.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	List<Teacher> findBySpecialty(String specialty);

	@Query(value ="select t.students from Teacher t where t.id = :id")
	List<Student> findStudentsByTeacherId(Long id);

	@Query(value ="select t.subjects from Teacher t where t.id = :id")
	List<Subject> findSubjectsByTeacherId(Long id);

	List<Teacher> findBySurname(String surname);

	List<Teacher> findByAddressContaining(String address);

	Optional<Teacher> findByDni(String dni);

}
