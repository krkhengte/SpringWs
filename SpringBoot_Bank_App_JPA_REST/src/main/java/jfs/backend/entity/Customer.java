package jfs.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Entity
@Setter
@Table(name = "CustomerInfo")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL) 
	private List<Mobile> mobiles=new ArrayList();


}
