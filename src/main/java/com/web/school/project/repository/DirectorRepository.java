package com.web.school.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.school.project.domain.Director;

public interface DirectorRepository extends JpaRepository<Director, Long>{

	Optional<Director> findBySurname(String surname);

}