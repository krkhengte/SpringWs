package jfs.backend.bms.user.service.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "userEmail")})
public class User {

	@Id
	private String userId;
	private String userName;
	private String userEmail;
	private String fullName;
	private LocalDate userDob;
	private String password;
	
}
