package jfs.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import jfs.backend.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.dto.AddressDto;
import jfs.backend.dto.CustomerDto;
import jfs.backend.entity.Address;
import jfs.backend.entity.Customer;
import jfs.backend.entity.Mobile;
import jfs.backend.repository.AddressRepository;
import jfs.backend.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerFunctions {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addCustomer(CustomerDto customersdto) {

		Integer id = customersdto.getId();
		
		  AddressDto addressDto = new AddressDto();
		  
		  Customer customers = this.DtoToCustomer(customersdto);
		  
		  List<Address> addresses = customers.getAddresses();
		  
		  if (addresses != null) { for (Address address : addresses) {
		  address.setCustomers(customers); } }
		  
		  
		  List<Mobile> mobiles = customers.getMobiles();
		  
		  if(mobiles != null) { for(Mobile mobile : mobiles) {
		  mobile.setCustomers(customers); } }
		 
		

		  //Customer save = this.customerRepository.save(customers);
		  customerRepository.save(customers);

		if (id != null) {
			return "Customer Added Successfully";
		} else {

			return "Failed To Add Customer";
		}

	}

	@Override
	public List<CustomerDto> getAllCustomer() {

		List<Customer> customers=this.customerRepository.findAll();

		List<CustomerDto> customerDtoList=customers.stream().map((cust)->this.modelMapper.map(cust,CustomerDto.class)).collect(Collectors.toList());

		return customerDtoList;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {
		Customer customer=this.customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","customerId",customerId));;

		customer.setAge(customerDto.getAge());
		customer.setName(customerDto.getName());

		return this.modelMapper.map(customer,CustomerDto.class);


	}

	@Override
	public String deleteCustomer(Integer customerId) {

		Customer customer=this.customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","customerId",customerId));
		this.customerRepository.delete(customer);
		return "Customer Deleted";
	}

	public Customer DtoToCustomer(CustomerDto customerDto) {

		return this.modelMapper.map(customerDto, Customer.class);
	}

	
	

}
