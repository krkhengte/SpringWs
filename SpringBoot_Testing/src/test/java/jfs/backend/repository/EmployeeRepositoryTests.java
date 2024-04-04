package jfs.backend.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jfs.backend.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	// JUnit test for save employee operation

	@DisplayName("JUnit test for save employee operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

		// given - precondition or setup

		Employee employee = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();

		// when - action or the behaviour that we are going to test

		Employee savedEmployee = employeeRepository.save(employee);

		// then - verify the output

		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
	}

	// JUnit Test For

	@DisplayName("JUnit case for get all employee name")
	@Test
	public void givenEmployeeList_whenFindAll_thenEmployeeList() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();

		Employee employee2 = Employee.builder().firstName("sangam").lastName("Dongre").email("sangam123@gmail.com")
				.build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

		// when - action or the behaviour that we are going to test

		List<Employee> employeeList = employeeRepository.findAll();

		// then - verify the output

		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
	}

	// JUnit Test For get employee by id

	@DisplayName("JUnit Test For get employee by id")
	@Test
	public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		// when - action or the behaviour that we are going to test

		Employee employeedb = employeeRepository.findById(employee1.getId()).get();

		// then - verify the output

		assertThat(employeedb).isNotNull();

	}

	// JUnit Test For get employee by email

	@DisplayName("JUnit Test For get employee by email")
	@Test
	public void givenEmaployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		// when - action or the behaviour that we are going to test

		Employee employeeDb = employeeRepository.findByEmail(employee1.getEmail()).get();

		// then - verify the output

		assertThat(employeeDb).isNotNull();

	}

	// JUnit Test For update employee

	@DisplayName("JUnit Test For update employee")
	@Test
	public void givenEmployeeObject_whenUpdateemployee_thenReturnUpdatedEmployee() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		// when - action or the behaviour that we are going to test

		Employee employee = employeeRepository.findById(employee1.getId()).get();

		employee.setEmail("vaibhav@gmail.com");
		employee.setFirstName("Vaibhav");

		Employee updatEmployee = employeeRepository.save(employee);

		// then - verify the output

		assertThat(updatEmployee.getEmail()).isEqualTo("vaibhav@gmail.com");
		assertThat(updatEmployee.getFirstName()).isEqualTo("Vaibhav");

	}

	// JUnit Test For delete employee

	@DisplayName("JUnit Test For delete employee")
	@Test
	public void givenEmployeeObject_whenDeleteEmployee_thenRemoveEmployee() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		// when - action or the behaviour that we are going to test

		employeeRepository.delete(employee1);

		Optional<Employee> employeeOpt = employeeRepository.findById(employee1.getId());

		// then - verify the output

		assertThat(employeeOpt).isEmpty();

	}

	// JUnit Test For get employee using JPQL query

	@DisplayName("JUnit Test For get employee using JPQL query")
	@Test
	public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		String firstName = "Kartik";
		String lastName = "Khengte";

		// when - action or the behaviour that we are going to test

		Employee savEmployee = employeeRepository.findByJPQL(firstName, lastName);

		// then - verify the output

		assertThat(savEmployee).isNotNull();

	}

	// JUnit Test For get employee using JPQL query with Name Params

	@DisplayName("JUnit Test For get employee using JPQL query with Name Params")
	@Test
	public void givenFirstNameAndLastName_whenFindByJPQLNameParams_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		String firstName = "Kartik";
		String lastName = "Khengte";

		// when - action or the behaviour that we are going to test

		Employee savEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);

		// then - verify the output

		assertThat(savEmployee).isNotNull();

	}

	// JUnit Test For custom query using native SQL with index

	@DisplayName("JUnit Test For custom query using native SQL with index ")
	@Test
	public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		String firstName = "Kartik";
		String lastName = "Khengte";

		// when - action or the behaviour that we are going to test

		Employee savEmployee = employeeRepository.findByNativeSQL(firstName, lastName);

		// then - verify the output

		assertThat(savEmployee).isNotNull();

	}

	// JUnit Test For custom query using native SQL with named params

	@DisplayName("JUnit Test For custom query using native SQL with Named params ")
	@Test
	public void givenFirstNameAndLastName_whenFindByNativeSQLNamedParams_thenReturnEmployeeObject() {

		// given - precondition or setup

		Employee employee1 = Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte123@gmail.com")
				.build();
		employeeRepository.save(employee1);

		String firstName = "Kartik";
		String lastName = "Khengte";

		// when - action or the behaviour that we are going to test

		Employee savEmployee = employeeRepository.findByNativeSQLNamed(firstName, lastName);

		// then - verify the output

		assertThat(savEmployee).isNotNull();

	}
	
	


}
