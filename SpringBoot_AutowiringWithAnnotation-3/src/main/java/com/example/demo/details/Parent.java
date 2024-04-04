package com.example.demo.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parent {

	private Child child;

	public Child getChild() {
		return child;
	}

	@Autowired
	public void setChild(Child child) {
		this.child = child;
	}

	public void display() {
		child.show();
		System.out.println("This Is Child Class");
	}

}
