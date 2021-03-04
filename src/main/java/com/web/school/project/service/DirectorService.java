package com.web.school.project.service;

import java.util.List;
import java.util.Optional;

import com.web.school.project.domain.Director;

public interface DirectorService {

	List<Director> findAll();

	Optional<Director> findById(Long id);

	Optional<Director> findBySurname(String surname);

	Optional<Director> findByYearWorked(String yearWorked);

	Optional<Director> findByDni(String dni);

}