package jfs.backend.service;

import java.util.List;
import java.util.Optional;

import jfs.backend.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	
	List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeById(Long id) ;
	
	Employee updatedEmployee(Employee updatedEmployee);
	
	void deleteEmployee(Long id);
	
}
