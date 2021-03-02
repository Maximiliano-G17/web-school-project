package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;


public interface TeacherService {

	List<Teacher> findAll();

	Optional<Teacher> findById(Long id);

	List<Teacher> findBySpecialty(String specialty);

	List<Student> findStudentsByTeacherId(Long id);

	List<Subject> findSubjectsByTeacherId(Long id);

	List<Teacher> findBySurname(String surname);

	List<Teacher> findByAddressContaining(String address);

	Optional<Teacher> findByDni(String dni);

}
