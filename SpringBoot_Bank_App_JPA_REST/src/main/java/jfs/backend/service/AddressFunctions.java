package jfs.backend.service;

import jfs.backend.dto.AddressDto;

public interface AddressFunctions {

	public String addAddress(Integer customerId,AddressDto addressDto);
	
	
	public String deleteAddress(Integer addressId, Integer customerId);
}
