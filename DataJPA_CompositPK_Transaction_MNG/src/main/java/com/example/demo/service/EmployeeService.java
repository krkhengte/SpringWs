package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	private AddressRepository addressRepository;

	public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void saveData() {
		
		Employee emp=new Employee();
		
		emp.setEmpId(205);
		emp.setEmpName("Sangam");
		emp.setEmpSalary(26000.00);
		employeeRepository.save(emp);
		
		int n=10/0;  // exception occure
		
		Address adr=new Address();
		adr.setAddrId(505);
		adr.setEmpId(205);
		adr.setCity("Hyderabad");
		adr.setState("Telengana");
		adr.setCountry("India");
		
		addressRepository.save(adr);
		
		
	}
	

}
