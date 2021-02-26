package com.web.school.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Optional<Student> findBySurname(String surname);
}
