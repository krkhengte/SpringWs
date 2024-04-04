
package jfs.backend.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.dto.MobileDto;
import jfs.backend.entity.Address;
import jfs.backend.entity.Customer;
import jfs.backend.entity.Mobile;
import jfs.backend.repository.CustomerRepository;
import jfs.backend.repository.MobileRepository;

@Service
public class MobileService implements MobileFunction {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MobileRepository mobileRepository;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public String addMobileNum(MobileDto mobileDto, Integer customerId) {

		Integer id = mobileDto.getId();
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		Customer customer2 = customer.get();
		Mobile mobile = this.modelMapper.map(mobileDto, Mobile.class);

		mobile.setCustomers(customer2);

		mobileRepository.save(mobile);

		if (id != null) {
			return "Mobile Number Added Successfull...";
		} else {
			return "Mobile Failed To Add";
		}
	}
		
		
		
	}

