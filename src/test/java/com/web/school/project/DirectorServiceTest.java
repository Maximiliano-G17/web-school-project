package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Director;
import com.web.school.project.service.DirectorService;

@SpringBootTest
public class DirectorServiceTest {
	
	@Autowired
	private DirectorService directorService;
	
	@Test
	public void findAll_returnAList() {
		List<Director> directorsFound = directorService.findAll();
		
		assertThat(directorsFound).isNotEmpty();
		assertEquals(3, directorsFound.size());
	}
	
	@Test
	public void findById_withIdExisting_returnADirector() {
		Long id = 16L;
		
		Optional<Director> directorFound = directorService.findById(id);
		
		assertThat(directorFound).isNotEmpty();
		assertEquals(id, directorFound.get().getId());
	}
	
	@Test
	public void findById_withIdNonexistent_returnEmpty() {
		Long id = -99L;
		
		Optional<Director> directorFound = directorService.findById(id);
		
		assertThat(directorFound).isEmpty();
	}
	
	@Test
	public void findBySurname_withSurnameExisting_returnADirector() {
		String surname = "Alfaro";
		
		Optional<Director> directorFound = directorService.findBySurname(surname);
		
		assertThat(directorFound).isNotEmpty();
		assertEquals(surname, directorFound.get().getSurname());
	}
	
	@Test
	public void findBySurname_withSurnameNonexistent_returnEmpty() {
		String surname = "ZZZZZZZZZZ";
		
		Optional<Director> directorFound = directorService.findBySurname(surname);
		
		assertThat(directorFound).isEmpty();
	}
}