package jfs.backend.bms.user.service.apiresponse;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterApiResponse {

	private String userId;
	private String userName;
	private String userEmail;
	private String fullName;
	private LocalDate userDob;

}
