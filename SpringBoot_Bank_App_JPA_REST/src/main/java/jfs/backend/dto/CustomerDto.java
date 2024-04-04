package jfs.backend.dto;

import java.util.List;

import jfs.backend.entity.Address;
import jfs.backend.entity.Mobile;
/*import jfs.backend.entity.Mobile;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private Integer id;
	private String name;
	private Integer age;

	private List<AddressDto> addresses;
	private List<MobileDto> mobile;

	/*
	 * private List<AddressDto> addresses; private List<MobileDto> mobile;
	 */
}
