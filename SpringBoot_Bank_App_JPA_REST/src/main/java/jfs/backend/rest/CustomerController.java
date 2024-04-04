package jfs.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jfs.backend.dto.CustomerDto;

import jfs.backend.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomerInfo(@RequestBody CustomerDto customersdto) {
		// String status="Customer Added Successfully";
		String addCust = customerService.addCustomer(customersdto);
		return new ResponseEntity<String>(addCust, HttpStatus.CREATED);

	}

	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<CustomerDto>> getALLCustomer(){

		List<CustomerDto> customerDtoList =customerService.getAllCustomer();

		return new ResponseEntity<List<CustomerDto>>(customerDtoList,HttpStatus.OK);
	}

	@PutMapping("/updateCustomer/{customerID}")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable Integer customerID){

		CustomerDto customer=customerService.updateCustomer(customerDto,customerID);

		return  new ResponseEntity<CustomerDto>(customer,HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public  ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId){
		String msg=customerService.deleteCustomer(customerId);

		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
