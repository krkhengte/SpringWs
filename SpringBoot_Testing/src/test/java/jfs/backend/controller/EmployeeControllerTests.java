package jfs.backend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jfs.backend.model.Employee;
import jfs.backend.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc; // To called rest APIS

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    // JUnit Test For create employee

    @DisplayName("JUnit Test For create employee")
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee()
            throws JsonProcessingException, Exception {

        // given - precondition or setup

        Employee employee = Employee.builder().firstName("Kartik").lastName("Khengte").email("kartik@gmail.com")
                .build();

        given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or the behaviour that we are going to test

        ResultActions responce = mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));

        // then - verify the output

        responce.andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                .andExpect(jsonPath("$.email", CoreMatchers.is(employee.getEmail())));
    }

    // JUnit Test For get all employees

    @DisplayName("JUnit Test For get all employees")
    @Test
    public void givenListOfEmployee_whenGetAllEmoloyee_thenReturnListOfEmployee() throws Exception {

        // given - precondition or setup

        List<Employee> listOfEmployees = new ArrayList<Employee>();
        listOfEmployees
                .add(Employee.builder().firstName("Kartik").lastName("Khengte").email("krkhengte@gmail.com").build());
        listOfEmployees
                .add(Employee.builder().firstName("Vaibhav").lastName("Khengte").email("vaibhav@gmail.com").build());

        given(employeeService.getAllEmployees()).willReturn(listOfEmployees);

        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(get("/api/employees")); //

        // then - verify the output

        response.andExpect(status().isOk()) // check status code
                .andDo(print()) // used for print the Json object
                .andExpect(jsonPath("$.size()", CoreMatchers.is(listOfEmployees.size()))); // check the size of employee list


    }

    // Positive scenario
    // JUnit Test For get employee by employee id

    @DisplayName("JUnit Test For get employee by employee id")
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception {

        // given - precondition or setup

        long employeeId = 1L;

        Employee employee = Employee.builder()
                .firstName("Kartik")
                .lastName("Khengte")
                .email("kartik@gmail.com")
                .build();

        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));

        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        // then - verify the output

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));

    }

    // negative scenario
    // JUnit Test For get employee by employee id

    @DisplayName("JUnit Test For get employee by invalid employee id")
    @Test
    public void givenInvalidEmployeeId_whenGetEmployeeById_thenReturnEmpty() throws Exception {

        // given - precondition or setup

        long employeeId = 1L;

        Employee employee = Employee.builder()
                .firstName("Kartik")
                .lastName("Khengte")
                .email("kartik@gmail.com")
                .build();

        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());

        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        // then - verify the output
        System.out.println("*******************");
        response.andExpect(status().isNotFound())

                .andDo(print());
        System.out.println("*******************");

    }


    // JUnit Test For update employee by employeeID Positive Scenario

    @DisplayName("JUnit Test For update employee by employeeID Positive Scenario")
    @Test
    public void givenEmployeeId_whenUpdatedEmployee_thenUpdatedEmployeeObject() throws JsonProcessingException, Exception {

        // given - precondition or setup

        long employeeId = 1L;

        Employee savedEmployee = Employee.builder()
                .firstName("Kartik")
                .lastName("Khengte")
                .email("kartik@gmail.com")
                .build();

        Employee updatedEmployee = Employee.builder()
                .firstName("Vaibhav")
                .lastName("Khengte")
                .email("vaibhav@gmail.com")
                .build();


        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(savedEmployee));

        given(employeeService.updatedEmployee(ArgumentMatchers.any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));


        // then - verify the output

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(updatedEmployee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(updatedEmployee.getLastName())))
                .andExpect(jsonPath("$.email", is(updatedEmployee.getEmail())));

    }


    // JUnit Test For update employee by employeeID Negative Scenario

    @DisplayName("JUnit Test For update employee by employeeID Negative Scenario")
    @Test
    public void givenInvalidEmployeeId_whenUpdateEmployee_thenReturnEmpty() throws JsonProcessingException, Exception {

        // given - precondition or setup


        long employeeId = 1L;

        Employee savedEmployee = Employee.builder()
                .firstName("Kartik")
                .lastName("Khengte")
                .email("kartik@gmail.com")
                .build();

        Employee updatedEmployee = Employee.builder()
                .firstName("Vaibhav")
                .lastName("Khengte")
                .email("vaibhav@gmail.com")
                .build();

        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());


        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        // then - verify the output

        System.out.println("#############################################################");

        response.andExpect(status().isNotFound())
                .andDo(print());

        System.out.println("#############################################################");

    }


    // JUnit Test For delete employee
    @DisplayName("JUnit Test For delete employee")
    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturnNothing() throws Exception {

        // given - precondition or setup

        long employeeId = 1L;

        willDoNothing().given(employeeService).deleteEmployee(employeeId);

        // when - action or the behaviour that we are going to test

        ResultActions response = mockMvc.perform(delete("/api/employees/{id}", employeeId));

        // then - verify the output

        response.andExpect(status().isOk())
                .andDo(print());

    }

}
