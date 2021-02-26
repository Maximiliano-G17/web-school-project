package com.web.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
