package com.web.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
