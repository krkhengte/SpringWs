package jfs.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	private Integer cId;
	private String title;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList();
}
