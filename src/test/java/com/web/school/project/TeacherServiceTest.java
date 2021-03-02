package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Student;
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
	public void ssssssssssssssssssssssssssssssssssssssssssssssssss() {
		Long id = 11L;
		List<Student> StudentsFound = teacherService.findStudentsById(id);
		
		assertThat(StudentsFound).isNotEmpty();
//		assertEquals(1,StudentsFound.size());
	}
}