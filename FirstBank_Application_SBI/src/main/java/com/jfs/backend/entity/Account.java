package com.jfs.backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accountDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SrNo")
	private Integer srno;
	@Column(name = "holderName")
	private String holdername;
	@Column(name = "accountNumber")
	private String accountnumber;
	@Column(name = "accountBalance")
	private Float accountbalance;
	@Column(name = "userName")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "holderEmailId")
	private String holderemailid;
	@Column(name = "holderGender")
	private String holdergender;
	@Column(name = "holderMobile")
	private String holdermobile;
	@CreationTimestamp
	@Column(name="Created_Date",updatable = false)
	private LocalDateTime createdDate;
	@UpdateTimestamp
	@Column(name="Updated_Date",insertable = false )
	private LocalDateTime updatedDate;

}
