package com.jfs.backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User_Master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData {
	@Id
	@Column(name = "UserID")
	private Integer userid;
	@Column(name = "UserName")
	private String username;
	@Column(name = "UserGender")
	private String gender;
	@Column(name = "UserAge")
	private Integer userage;
	@Column(name = "UserCountry")
	private String country;



}
