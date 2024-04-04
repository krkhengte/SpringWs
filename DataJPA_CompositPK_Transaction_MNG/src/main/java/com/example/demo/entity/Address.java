package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Address")
@Data
public class Address {

	@Id
	@Column(name="Address_Id")
	private Integer addrId;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Country")
	private String country;
	@Column(name="Emp_Id")
	private Integer EmpId;
	
}
