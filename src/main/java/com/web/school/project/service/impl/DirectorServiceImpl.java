package com.web.school.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.school.project.domain.Director;
import com.web.school.project.repository.DirectorRepository;
import com.web.school.project.service.DirectorService;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService{
	
	@Autowired
	private DirectorRepository directorRepo;

	@Override
	public List<Director> findAll() {
		return directorRepo.findAll();
	}

	@Override
	public Optional<Director> findById(Long id) {
		return directorRepo.findById(id);
	}

	@Override
	public Optional<Director> findBySurname(String surname) {
		return directorRepo.findBySurname(surname);
	}

	@Override
	public Optional<Director> findByYearWorked(String yearWorked) {
		return directorRepo.findByYearWorked(yearWorked);
	}

	@Override
	public Optional<Director> findByDni(String dni) {
		return directorRepo.findByDni(dni);
	}
}