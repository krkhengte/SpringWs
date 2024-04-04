package jfs.backend.bms.user.service.Service;

import jfs.backend.bms.user.service.apiresponse.LoginApiResponse;
import jfs.backend.bms.user.service.payload.LoginDto;

public interface LoginService {

	public LoginApiResponse loginUser(LoginDto loginDto);
	
}
