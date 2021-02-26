package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Student;
import com.web.school.project.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void findById_withIdExisting_returnAStudent() {
		Long id = 1L;
		
		Optional<Student> studentFound = studentService.findById(id);
		
		assertThat(studentFound).isNotEmpty();
		assertEquals(id,studentFound.get().getId());
	}
	
	@Test
	public void findById_withIdNonexistent_returnEmpty() {
		Long id = -99L;
		
		Optional<Student> studentFound = studentService.findById(id);
		
		assertThat(studentFound).isEmpty();
	}

	@Test
	public void findBySurname_withSurnameExisting_returnAStudent() {
		String surname = "Gimenez";
		
		Optional<Student> studentFound = studentService.findBySurname(surname);
		
		assertThat(studentFound).isNotEmpty();
		assertEquals(surname,studentFound.get().getSurname());
	}
	
	@Test
	public void findBySurname_withSurnameNonexistent_returnEmpty() {
		String surname = "LALALALA";
		
		Optional<Student> studentFound = studentService.findBySurname(surname);
		
		assertThat(studentFound).isEmpty();
	}
}