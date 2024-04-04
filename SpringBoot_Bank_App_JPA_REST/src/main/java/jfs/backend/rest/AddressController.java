package jfs.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.dto.AddressDto;
import jfs.backend.service.AddressService;

@RestController
public class AddressController {

	
	  @Autowired private AddressService addressService;
	  
	  @PostMapping("/post")
	  public ResponseEntity<String> addAddressInfo(@RequestBody AddressDto addressDto, Integer customerId) {
	  
	  String msg=addressService.addAddress(customerId, addressDto);
	  
	  return new ResponseEntity<>(msg, HttpStatus.CREATED); }
	  
	  
	  
	  @DeleteMapping("/customer/{addressId}/{customerId}")
	  public ResponseEntity<String> deleteAddressInfo(@PathVariable Integer addressId, @PathVariable Integer customerId){
	  
	  String deleteAddress = addressService.deleteAddress(addressId, customerId);
	  
	  return new ResponseEntity<>(deleteAddress,HttpStatus.OK); }
	 
}
