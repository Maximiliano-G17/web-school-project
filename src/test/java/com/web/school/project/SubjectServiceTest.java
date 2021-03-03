package com.web.school.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.school.project.domain.Subject;
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
	public void findByTeacherId_withTeacherIdExisting_returnAListSubject() {
		Long id = 11L;
		
		List<Subject> subjectsFound = subjectService.findByTeacherId(id);
		
		assertThat(subjectsFound).isNotEmpty();
		assertEquals(id, subjectsFound.get(0).getTeacher().getId());
	}
	
	@Test
	public void findByTeacherId_withTeacherIdNonexistent_returnAListSubjectEmpty() {
		Long id = -99L;
		
		List<Subject> subjectsFound = subjectService.findByTeacherId(id);
		
		assertThat(subjectsFound).isEmpty();
	}
	
	@Test
	public void findByStudentsId_withStudentsIdExisting_returnAListSubject() {
		Long id = 1L;
		
		List<Subject> subjectsFound = subjectService.findByStudentsId(id);
		
		assertThat(subjectsFound).isNotEmpty();
		assertEquals(3, subjectsFound.size());
	}
	
	@Test
	public void findByStudentsId_withStudentsIdNonexistent_returnAListSubject() {
		Long id = -99L;
		
		List<Subject> subjectsFound = subjectService.findByStudentsId(id);
		
		assertThat(subjectsFound).isEmpty();
	}
}