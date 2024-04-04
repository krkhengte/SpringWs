package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
