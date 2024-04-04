package jfs.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private Integer productId;
	private String productName;
	
	@ManyToMany(mappedBy = "products")
	private List<Category> categories = new ArrayList();
}
