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
import com.web.school.project.service.SubjectService;

@SpringBootTest
public class SubjectServiceTest {
	
	@Autowired
	private SubjectService subjectService;
	
	@Test
	public void findAll_returnAList() {
		List<Subject> subjectsFound = subjectService.findAll();
		
		assertThat(subjectsFound).isNotEmpty();
		assertEquals(5, subjectsFound.size());
	}
	
	@Test
	public void findById_withIdExisting_returnASubject() {
		Long id = 1L;
		
		Optional<Subject> subjectFound = subjectService.findById(id);
		
		assertThat(subjectFound).isNotEmpty();
		assertEquals(id, subjectFound.get().getSubject_id());
	}
	
	@Test
	public void findById_withIdNonexistent_returnASubjectEmpty() {
		Long id = -99L;
		
		Optional<Subject> subjectFound = subjectService.findById(id);
		
		assertThat(subjectFound).isEmpty();
	}
	
	@Test
	public void findByName_withNameExisting_returnASubject() {
		String subject = "Matematica";
		
		Optional<Subject> subjectFound = subjectService.findByName(subject);
		
		assertThat(subjectFound).isNotEmpty();
		assertEquals(subject, subjectFound.get().getName());
	}
	
	@Test
	public void findByName_withNameNonexistent_returnASubjectEmpty() {
		String subject = "ZZZZZZZZZ";
		
		Optional<Subject> subjectFound = subjectService.findByName(subject);
		
		assertThat(subjectFound).isEmpty();
	}
	
	@Test
	public void findStudentsBySubjectId_withSubjectIdExisting_returnAListStudents() {
		Long id = 1L;
		
		List<Student> StudentsFound = subjectService.findStudentsBySubjectId(id);
		
		assertThat(StudentsFound).isNotEmpty();
		assertEquals(9, StudentsFound.size());
	}
	
	@Test
	public void findStudentsBySubjectId_withSubjectIdNonexistent_returnAListEmpty() {
		Long id = -99L;
		
		List<Student> StudentsFound = subjectService.findStudentsBySubjectId(id);
		
		assertThat(StudentsFound).isEmpty();
	}
	
	@Test
	public void findteachersBySubjectId_withSubjectIdExisting_returnAListTeacher() {
		Long id = 1L;
		
		List<Teacher> teachersFound = subjectService.findTeacherBySubjectId(id);
		
		assertThat(teachersFound).isNotEmpty();
		assertEquals("Ingles", teachersFound.get(0).getSpecialty());
	}
	
	@Test
	public void findteachersBySubjectId_withSubjectIdNonexistent_returnAListEmpty() {
		Long id = -99L;
		
		List<Teacher> teachersFound = subjectService.findTeacherBySubjectId(id);
		
		assertThat(teachersFound).isEmpty();
	}
}