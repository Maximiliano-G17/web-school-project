package com.web.school.project.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Student extends Person{
	
	@Column
	private String yearStudied;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "students_teachers",joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="teacher_id"))
	private List<Teacher> teachers = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "students_subject",joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="subject_id"))
	private List<Subject> subjects = new ArrayList<>();

	public String getYearStudied() {
		return yearStudied;
	}

	public void setYearStudied(String yearStudied) {
		this.yearStudied = yearStudied;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

//	@Override
//	public String toString() {
//		return "Student [yearStudied=" + yearStudied + ", teachers=" + teachers + ", subjects=" + subjects + "]";
//	}
}