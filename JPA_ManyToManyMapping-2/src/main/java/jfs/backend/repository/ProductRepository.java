package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Product;

@Repository
@EnableJpaRepositories
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
