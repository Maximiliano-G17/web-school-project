package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
	
	@Test
	public void findByYearStudied_withYearExisting_returnAListStudents() {
		String year = "2019";
		
		List<Student> studentsFound = studentService.findByYearStudied(year);
		
		assertThat(studentsFound).isNotEmpty();
		assertEquals(year,studentsFound.get(0).getYearStudied());
	}
	
	@Test
	public void findByYearStudied_withYearNonexistent_returnAListEmpty() {
		String year = "9999";
		
		List<Student> studentsFound = studentService.findByYearStudied(year);
		
		assertThat(studentsFound).isEmpty();
	}
	
	@Test
	public void findByAddressStudied_withAddressExisting_returnAListStudents() {
		String address = "Catriel";
		
		List<Student> studentsFound = studentService.findByAddressContaining(address);
		
		assertThat(studentsFound).isNotEmpty();
		assertEquals(true,studentsFound.get(0).getAddress().contains(address));
	}
	
	@Test
	public void findByDni_withDniExisting_returnAStudent() {
		String dni = "36860436";
		
		Optional<Student> studentFound = studentService.findByDni(dni);
		
		assertThat(studentFound).isNotEmpty();
		assertEquals(dni,studentFound.get().getDni());
	}
	
	@Test
	public void findByDni_withDniNonexistent_returnEmpty() {
		String dni = "ZZZZZZZZ";
		
		Optional<Student> studentFound = studentService.findByDni(dni);

		assertThat(studentFound).isEmpty();
	}
}