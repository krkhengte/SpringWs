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
	@Column(name = "MAME", length = 20)
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList();
	
}
