package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="Employee_Id")
	private Integer empId;
	@Column(name="Employee_Name")
	private String empName;
	@Column(name="Employee_Salary")
	private Double empSalary;
}
