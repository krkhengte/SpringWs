package jfs.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jfs.backend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	Optional<Employee> findByEmail(String email);
	
	
	// define custom query using JPQl with index parameter
	
	@Query("select e from Employee e where e.firstName=?1 and e.lastName=?2")
	Employee findByJPQL(String firstName,String lastName);
	
	
	@Query("select e from Employee e where e.firstName=:firstName and e.lastName=:lastName")
	Employee findByJPQLNamedParams(@Param("firstName") String firstName,@Param("lastName") String lastName);
	
	
	// define custom query using native SQL with index param
	
	@Query(value = "select * from employees e where e.first_name=?1 and e.last_name=?2",nativeQuery = true)
	Employee findByNativeSQL(String firstName,String lastName);
	
	
	// define custom query using native SQL with named param
	
	@Query(value = "select * from employees e where e.first_name=:firstName and e.last_name=:lastName",nativeQuery = true)
	Employee findByNativeSQLNamed(@Param("firstName") String firstName,@Param("lastName")String lastName);
	
}
