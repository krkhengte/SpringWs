package jfs.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "micro_users")
public class User {

	@Id
	@Column(name = "Id")
	private String userId;
	private String userName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	private String password;
	@Transient
	private List<Rating> ratings=new ArrayList<>();
	
}
