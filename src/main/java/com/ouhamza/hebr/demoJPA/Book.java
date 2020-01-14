package com.ouhamza.hebr.demoJPA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	@Id
	private Long id;
	private String name;
	
	  @ManyToOne private Student student;
	  
	  public Student getStudent() { return student; } public void
	  setStudent(Student student) { this.student = student; }
	 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
