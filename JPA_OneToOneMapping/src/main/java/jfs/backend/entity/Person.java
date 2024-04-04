package jfs.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PersonInfo")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	
	// By Using Eager we can get both tables data
	@OneToOne(mappedBy = "person" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER) // We can save both table data at single time
	@JoinColumn(name = "Person_Id") // use To Rename The Column Name
	private Address address;
	
}
