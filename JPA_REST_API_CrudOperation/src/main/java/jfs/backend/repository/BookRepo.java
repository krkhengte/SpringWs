package jfs.backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

	
}
