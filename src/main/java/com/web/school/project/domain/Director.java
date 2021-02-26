package com.web.school.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Director {
	
	@Column
	private String yearWorked;

	public String getYearWorked() {
		return yearWorked;
	}

	public void setYearWorked(String yearWorked) {
		this.yearWorked = yearWorked;
	}
}
