package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Person;
import com.web.school.project.service.PersonService;

@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void findAll_returnAList() {
		List<Person> peopleFound = personService.findAll();
		
		assertThat(peopleFound).isNotEmpty();
		assertEquals(16, peopleFound.size());
	}
}