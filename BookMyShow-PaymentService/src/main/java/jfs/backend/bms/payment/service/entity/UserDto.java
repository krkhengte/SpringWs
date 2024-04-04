package jfs.backend.bms.payment.service.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto implements Serializable {

	private String userId;
	private String userName;
	private String userEmail;
	private String fullName;
	private LocalDate userDob;
	private String password;
}
