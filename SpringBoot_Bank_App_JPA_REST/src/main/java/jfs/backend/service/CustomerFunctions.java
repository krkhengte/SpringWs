package jfs.backend.service;

import jfs.backend.dto.CustomerDto;

import java.util.List;

public interface CustomerFunctions {

	public String addCustomer(CustomerDto customersdto);
	/*
	 * public void viewCustomer(); public void searchCustomer(); public void back();
	 */

	 List<CustomerDto> getAllCustomer();

	 CustomerDto updateCustomer(CustomerDto customerDto,Integer customerId);

	 String deleteCustomer(Integer customerId);



}
