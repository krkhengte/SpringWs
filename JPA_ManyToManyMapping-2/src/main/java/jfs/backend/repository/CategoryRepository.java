package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Category;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	
}
