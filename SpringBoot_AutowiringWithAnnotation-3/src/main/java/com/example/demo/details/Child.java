package com.example.demo.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Child {

	private Student student;

	@Autowired
	public Child(Student student) {
		super();
		this.student = student;
	}

	public void show() {
		student.displayDetails();
		System.out.println("This is Parent Class");
	}
}
