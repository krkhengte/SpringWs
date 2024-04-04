package jfs.backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.Category;
import jfs.backend.entity.Product;
import jfs.backend.repository.CategoryRepository;
import jfs.backend.repository.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void categoryData() {

		System.out.println("1");

		Product p1 = new Product();
		p1.setProductId(1);
		p1.setProductName("IPhone 14 Pro Max");

		Product p2 = new Product();
		p2.setProductId(2);
		p2.setProductName("Vivo T1 5G");

		Product p3 = new Product();
		p3.setProductId(3);
		p3.setProductName("SamSung S23 Ultra Pro");

		Category c1 = new Category();
		c1.setCId(10);
		c1.setTitle("Electronic");

		Category c2 = new Category();
		c2.setCId(11);
		c2.setTitle("Smart Phone");

		/*
		 * List<Category> p1Categories1 = new ArrayList(); p1Categories1.add(c1);
		 * p1Categories1.add(c2);
		 * 
		 * List<Category> p1Categories2 = new ArrayList(); p1Categories2.add(c1);
		 * p1Categories2.add(c2);
		 * 
		 * List<Category> p1Categories3 = new ArrayList(); p1Categories3.add(c1);
		 * 
		 * p1.setCategories(p1Categories1); p2.setCategories(p1Categories2);
		 * p3.setCategories(p1Categories3);
		 */
		/*
		 * p1.setCategories(Arrays.asList(c1, c2)); p2.setCategories(Arrays.asList(c1,
		 * c2)); p3.setCategories(Arrays.asList(c1));
		 */

		List<Product> c1Product = c1.getProducts();
		c1Product.add(p1);
		c1Product.add(p2);
		c1Product.add(p3);

		List<Product> c2Product =c2.getProducts();
		c2Product.add(p1);
		c2Product.add(p2);

		c1.setProducts(c1Product);
		c2.setProducts(c2Product);

		categoryRepository.save(c1);
		categoryRepository.save(c2);

	}

}
