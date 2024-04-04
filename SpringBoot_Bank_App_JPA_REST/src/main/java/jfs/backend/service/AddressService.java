package jfs.backend.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.dto.AddressDto;
import jfs.backend.entity.Address;
import jfs.backend.entity.Customer;
import jfs.backend.exception.ResourceNotFoundException;
import jfs.backend.repository.AddressRepository;
import jfs.backend.repository.CustomerRepository;

@Service
public class AddressService implements AddressFunctions {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addAddress(Integer customerId, AddressDto addressDto) {

		Integer id = addressDto.getId();
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		Customer customer2 = customer.get();
		Address address = this.modelMapper.map(addressDto, Address.class);

		address.setCustomers(customer2);

		addressRepository.save(address);

		if (id != null) {
			return "Address Added Successfully";
		} else {
			return "Address Failed To Add";
		}
	}

	@Override
	public String deleteAddress(Integer addressId, Integer customerId) {
		
        Address address= this.addressRepository.findById (addressId)
                .orElseThrow (()->new ResourceNotFoundException ("Address","address Id",addressId));
        Customer customer=this.customerRepository.findById (customerId)
                .orElseThrow (()->new ResourceNotFoundException ("Customer","customer Id",customerId));
        List<Address>addresses=this.addressRepository.findByCustomers(customer);
        Address address2 = addresses.stream ()
                .filter (address1 -> address1.equals (address))
                .findAny ()
                .orElseThrow (() -> new ResourceNotFoundException ("Address", "AdressId", addressId));
        System.out.println (address2.getId ()+"deleted");
        this.addressRepository.deleteById (address2.getId());
		return "Address Deleted Successfully...";
		

	}

}
