package jfs.backend.dto;

import java.util.List;

import jfs.backend.entity.Address;
import jfs.backend.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
	
	
	private Integer id;
	private String city;
	private String state;
	private String country;
	private String pincode;
	

}
