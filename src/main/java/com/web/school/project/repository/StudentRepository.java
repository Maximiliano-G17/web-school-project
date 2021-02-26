package com.web.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
