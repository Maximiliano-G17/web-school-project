package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Student;
import com.web.school.project.domain.Subject;
import com.web.school.project.domain.Teacher;
import com.web.school.project.service.TeacherService;

@SpringBootTest
public class TeacherServiceTest {
	
	@Autowired
	private TeacherService teacherService;
	
	@Test
	public void findAll_returnAListTeachers() {
		List<Teacher> teachersFound = teacherService.findAll();
		
		assertThat(teachersFound).isNotEmpty();
		assertEquals(5,teachersFound.size());
	}
	
	@Test
	public void findById_withIdExisting_returnATeacher() {
		Long id = 11L;
		Optional<Teacher> teacherFound = teacherService.findById(id);
		
		assertThat(teacherFound).isNotEmpty();
		assertEquals(id,teacherFound.get().getId());
	}
	
	@Test
	public void findById_withIdNonexistent_returnEmpty() {
		Long id = -99L;
		Optional<Teacher> teacherFound = teacherService.findById(id);
		
		assertThat(teacherFound).isEmpty();
	}
	
	@Test
	public void findBySpecialty_withSpecialtyExisting_returnAListTeachers() {
		String specialty = "Matematica";
		List<Teacher> teachersFound = teacherService.findBySpecialty(specialty);
		
		assertThat(teachersFound).isNotEmpty();
		assertEquals(1,teachersFound.size());
	}
	
	@Test
	public void findBySpecialty_withSpecialtyNonexistent_returnEmpty() {
		String specialty = "ZZZZZZZ";
		List<Teacher> teachersFound = teacherService.findBySpecialty(specialty);
		
		assertThat(teachersFound).isEmpty();
	}
	
	@Test
	public void findStudentsByTeacherId_withIdExisting_returnAListStudent() {
		Long id = 11L;
		List<Student> studentsFound = teacherService.findStudentsByTeacherId(id);
		
		assertThat(studentsFound).isNotEmpty();
		assertEquals(7,studentsFound.size());
	}
	
	@Test
	public void findStudentsByTeacherId_withIdNonexistent_returnEmpty() {
		Long id = -99L;
		List<Student> studentsFound = teacherService.findStudentsByTeacherId(id);
		
		assertThat(studentsFound).isEmpty();
	}
	
	@Test
	public void findSubjectsByTeacherId_withIdExisting_returnAListSubjects() {
		Long id = 11L;
		List<Subject> subjectsFound = teacherService.findSubjectsByTeacherId(id);
		
		assertThat(subjectsFound).isNotEmpty();
		assertEquals(1,subjectsFound.size());
	}
	
	@Test
	public void findSubjectsByTeacherId_withIdNonexistent_returnEmpty() {
		Long id = -99L;
		List<Subject> subjectsFound = teacherService.findSubjectsByTeacherId(id);
		
		assertThat(subjectsFound).isEmpty();
	}
	
	@Test
	public void findBySurname_withSurnameExisting_returnAListTeachers() {
		String surname = "Acosta";
		List<Teacher> teachersFound = teacherService.findBySurname(surname);
		
		assertThat(teachersFound).isNotEmpty();
		assertEquals(1,teachersFound.size());
	}
	
	@Test
	public void findBySurname_withSurnameNonexistent_returnEmpty() {
		String surname = "ZZZZZ";
		List<Teacher> teachersFound = teacherService.findBySurname(surname);
		
		assertThat(teachersFound).isEmpty();
	}
	
	@Test
	public void findByAddress_withAddressExisting_returnAListTeachers() {
		String address = "M";
		List<Teacher> teachersFound = teacherService.findByAddressContaining(address);
		
		assertThat(teachersFound).isNotEmpty();
		assertEquals(2,teachersFound.size());
	}
	
	@Test
	public void findByDni_withDniExisting_returnATeacher() {
		String dni = "16321654";
		Optional<Teacher> teacherFound = teacherService.findByDni(dni);
		
		assertThat(teacherFound).isNotEmpty();
		assertEquals(dni,teacherFound.get().getDni());
	}
	
	@Test
	public void findByDni_withDniNonexistent_returnEmpty() {
		String dni = "-16321654";
		Optional<Teacher> teacherFound = teacherService.findByDni(dni);
		
		assertThat(teacherFound).isEmpty();
	}
}