package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import jfs.backend.entity.Person;

@Repository
@EnableJpaRepositories
public interface PersonRepository extends CrudRepository<Person, Integer>{

	//public Person findByPNameAndCity(String name,String city);
	 public Person findByName(String name); 
}
