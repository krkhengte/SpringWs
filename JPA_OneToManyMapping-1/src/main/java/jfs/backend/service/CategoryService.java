
  package jfs.backend.service;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
  
  import jfs.backend.entity.Category; import jfs.backend.entity.Product; import
  jfs.backend.repository.CategoryRepo;
  
  @Service public class CategoryService {
  
  @Autowired private CategoryRepo categoryRepo;
  
  public void addcategoryService() {
  
  Product product1=new Product();
  product1.setProductName("I Phone 14 Pro Max");
  
  Product product2=new Product(); product2.setProductName("Vivo T1 5G");
  
  Product product3=new Product(); product1.setProductName("One Plus 11 pro");
  
  
  Category category1=new Category(); category1.setCategoryName("Electronic");
  
  Category category2=new Category();
  category2.setCategoryName("Mobile Phones");
  
  List<Product> category1Products = category1.getProducts();
  category1Products.add(product1); category1Products.add(product2);
  category1Products.add(product3);
  
  
  List<Product> category2Products = category2.getProducts();
  category2Products.add(product1); category2Products.add(product2);
  
  categoryRepo.save(category1); categoryRepo.save(category2);
  
  
  } }
 