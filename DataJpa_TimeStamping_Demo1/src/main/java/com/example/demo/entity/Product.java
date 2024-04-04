package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Product_Master")
@Data
public class Product {

	@Id
	@Column(name="Product_Id")
	@GeneratedValue
	private Integer pid;
	@Column(name="Product_Name")
	private String pName;
	@Column(name="Product_Price")
	private Double price;
	
	@CreationTimestamp
	@Column(name = "Created_Date",updatable = false) 
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "Updated_Date",insertable = false	) 
	private LocalDateTime updatedDate;

	
}
