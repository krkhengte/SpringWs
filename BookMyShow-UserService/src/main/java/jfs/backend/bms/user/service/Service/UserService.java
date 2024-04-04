package jfs.backend.bms.user.service.Service;

import java.util.List;
import java.util.Map;

import jfs.backend.bms.user.service.apiresponse.BookingResponse;
import jfs.backend.bms.user.service.apiresponse.RegisterApiResponse;
import jfs.backend.bms.user.service.payload.UserDto;

public interface UserService {

	// create User
	
	public RegisterApiResponse createUser(UserDto user);
	
	// update User
	
	public UserDto updateUser(UserDto userDto,String userId);
	
	// getALlUser
	
	public List<UserDto> getAllUsers();
	
	
	public UserDto getUserById(String userId);
	
	public UserDto updateSpecificField(String userId, Map<String, Object> fields);
	
	public List<BookingResponse> getBookingDetails(String userId);
	
	
}
