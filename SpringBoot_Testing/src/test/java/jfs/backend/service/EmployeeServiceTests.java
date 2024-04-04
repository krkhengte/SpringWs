package jfs.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jfs.backend.execption.ResourceNotFoundException;
import jfs.backend.model.Employee;
import jfs.backend.repository.EmployeeRepository;
import jfs.backend.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private Employee employee;

	@BeforeEach
	public void setup() {

		// employeeRepository = Mockito.mock(EmployeeRepository.class);

		// employeeService = new EmployeeServiceImpl(employeeRepository);

		employee = Employee
				.builder().id(1L)
				.firstName("Kartik")
				.lastName("Khengte")
				.email("krkhengate123@gmail.com")
				.build();

	}

	// JUnit Test For saveEmployee method

	@DisplayName("JUnit Test For saveEmployee method")
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {

		// given - precondition or setup

		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());

		System.out.println(employeeRepository);
		System.out.println(employeeService);
		given(employeeRepository.save(employee)).willReturn(employee);

		// when - action or the behaviour that we are going to test

		Employee savedEmployee = employeeService.saveEmployee(employee);
		// then - verify the output

		// System.out.println(savedEmployee);

		Assertions.assertThat(savedEmployee).isNotNull();

	}

	// JUnit Test For saveEmployee method witch throw exception

	@DisplayName("JUnit Test For saveEmployee method witch throw exception")

	@Test
	public void givenExistingEmail_whenSaveEmployee_thenReturnThrowException() {

		// given - precondition or setup

		// System.out.println("1");

		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.of(employee));

		// BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

		// System.out.println("2");

		// when - action or the behaviour that we are going to test

		org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {

			employeeService.saveEmployee(employee);
		});

		// then -verify the output

		verify(employeeRepository, never()).save(any(Employee.class));
	}

	// JUnit Test For get all Employee

	@DisplayName("JUnit Test For get all Employee")
	@Test
	public void givenEmployeeList_whenGetAllEmployee_thenReturnEmployeeList() {

		// given - precondition or setup
		
		Employee employee1 = Employee
				.builder().id(2L)
				.firstName("Sangam")
				.lastName("Dongre")
				.email("sangam123@gmail.com")
				.build();


		given(employeeRepository.findAll()).willReturn(List.of(employee,employee1));
		
		// when - action or the behaviour that we are going to test
		
		List<Employee> allEmployees = employeeService.getAllEmployees();

		System.out.println(allEmployees);
		
		// then - verify the output
		
		assertThat(allEmployees).isNotNull();
		assertThat(allEmployees.size()).isEqualTo(2);
		

	}
	
	
	
	// JUnit Test For get all Employee method (negative scenario)

	@DisplayName("JUnit Test For get all Employee method (negative scenario)")
	@Test
	public void givenEmptyEmployeeList_whenGetAllEmployee_thenReturnEmptyEmployeeList() {

		// given - precondition or setup
		
		Employee employee1 = Employee
				.builder().id(2L)
				.firstName("Sangam")
				.lastName("Dongre")
				.email("sangam123@gmail.com")
				.build();


		given(employeeRepository.findAll()).willReturn(Collections.emptyList());
		
		// when - action or the behaviour that we are going to test
		
		List<Employee> allEmployees = employeeService.getAllEmployees();

		System.out.println(allEmployees);
		
		// then - verify the output
		
		assertThat(allEmployees).isEmpty();
		assertThat(allEmployees.size()).isEqualTo(0);
		

	}
	
	
	// JUnit Test For get employee by id

	@DisplayName("JUnit Test For get employee by id")
	@Test
	public void givenEmployeeId_whenfindById_thenReturnEmployeeObject() {

		// given - precondition or setup
		
		given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

		// when - action or the behaviour that we are going to test

		Employee emp1 = employeeService.getEmployeeById(employee.getId()).get();
		
		// then - verify the output
		
		assertThat(emp1).isNotNull();
		

	}
	
	
	// JUnit Test For update employee 

	@DisplayName("JUnit Test For update employee ")
	@Test
	public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployeeObject() {

		// given - precondition or setup
		
		given(employeeRepository.save(employee)).willReturn(employee);
		
		employee.setFirstName("Vaibhav");
		employee.setEmail("vaibhav@gmail.com");
		
		given(employeeRepository.save(employee)).willReturn(employee);

		// when - action or the behaviour that we are going to test

		Employee updatedEmployee = employeeService.updatedEmployee(employee);
		
		// then - verify the output
		
		assertThat(updatedEmployee).isNotNull();
		assertThat(updatedEmployee.getFirstName().equals("Vaibhav") && updatedEmployee.getEmail().equals("vaibhav@gmail.com"));

	}
	
	
	// JUnit Test For delete employee by id

	@DisplayName("JUnit Test For delete employee by id")
	@Test
	public void givenEmployeeId_whenDeleteById_thenNothing() {

		long employeeId=1L;
		
		// given - precondition or setup
		
		willDoNothing().given(employeeRepository).deleteById(employeeId);

		// when - action or the behaviour that we are going to test
		
		employeeService.deleteEmployee(employeeId);

		// then - verify the output
		
		verify(employeeRepository,times(1)).deleteById(employeeId);

	}


}
