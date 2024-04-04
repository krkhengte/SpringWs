package jfs.backend.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer id;
	@NotEmpty
	@Size(min = 4,message = "User name Must be minimum 4 Charecters")
	private String name;
	@Email(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$", message = "Email should be in the format abc@gmail.com")	
	private String email;
	@NotEmpty()
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
	private String password;
	@NotEmpty()
	private String about;
	
}
