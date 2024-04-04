package jfs.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.execption.ResourceNotFoundException;
import jfs.backend.model.Employee;
import jfs.backend.repository.EmployeeRepository;
import jfs.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		Optional<Employee> employeeOpt = employeeRepository.findByEmail(employee.getEmail());

		if (employeeOpt.isPresent()) {
			
		//	System.out.println("Given employee is elready exists with given email:" + employee.getEmail());
			throw new ResourceNotFoundException("Given employee is elready exists with given email:" + employee.getEmail());
		}

		return employeeRepository.save(employee);
	}

	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
	
		
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updatedEmployee(Employee updatedEmployee) {
		
		return employeeRepository.save(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		
		employeeRepository.deleteById(id);
		
	}

}
