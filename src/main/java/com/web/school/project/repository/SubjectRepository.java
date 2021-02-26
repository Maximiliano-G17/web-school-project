package com.web.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
