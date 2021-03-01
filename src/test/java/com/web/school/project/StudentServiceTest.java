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
		String address = "tri";
		
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
	
	@Test
	public void findByAll_returnAListStudents() {		
		List<Student> studentsFound = studentService.findByAll();
		
		assertThat(studentsFound).isNotEmpty();
		assertEquals(1,studentsFound.size());
	}
	
	@Test
	public void findByTeachersByStudent_withStudentIdExisting_returnAListTeachers() {		
		Long id = 1L;
		
		Optional<Student> studentFound =  studentService.findById(id);	 
		List<Teacher> teachersByStudent = studentFound.get().getTeachers();
		
		assertThat(teachersByStudent).isNotEmpty();
		assertEquals(3,teachersByStudent.size());
	}
	
	@Test
	public void findBySubjectsByStudent_withStudentIdExisting_returnAListSubjects() {		
		Long id = 1L;

		Optional<Student> studentFound =  studentService.findById(id);	 
		List<Subject> SubjectsByStudent = studentFound.get().getSubjects();
		
		assertThat(SubjectsByStudent).isNotEmpty();
		assertEquals(3,SubjectsByStudent.size());
	}
	
	@Test
	public void updateStudent_withStudentIdExisting_returnAStudent() {		
		Long id = 1L;
		
		Optional<Student> studentFound =  studentService.findById(id);	
		studentFound.get().setName("Maxi Alexis");
		Student studentUpdated = studentService.save(studentFound.get());
		
		assertEquals(id,studentUpdated.getId());
	}
	
	@Test
	public void deleteStudent_withStudentIdExisting_returnAStudent() {		
		Long id = 9L;
		
		int sizeBeforeDelete = studentService.findByAll().size();
		studentService.delete(id);
		int sizeAfterDelete = studentService.findByAll().size();
		
		assertEquals(sizeAfterDelete,sizeBeforeDelete-1);
	}
}