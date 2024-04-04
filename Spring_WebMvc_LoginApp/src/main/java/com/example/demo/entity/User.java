package com.example.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="UserData")
public class User {

	@Id
	@Column(name="SrNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;
	@Column(name="UserName")
	@NotEmpty(message = "User Name Should not Be Empty")
	private String userName;
	@Column(name="Userpassword")
	@NotEmpty(message = "User Password Should not Be Empty")
	private String userPassword;
	@Column(name="UserGmail")
	@Email(message = "Enter Valid Email Id")
	@NotEmpty(message = "Email Nimber Should not Be Empty")
	private String userGmail;
	@Column(name="UserMobile")
	@NotEmpty(message = "Mobile Nimber Should not Be Empty")
	private String userMobile;
}
