package jfs.backend.bms.user.service.payload;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
	private String userId;
	@NotEmpty(message = "UserName can not be Empty")
	@NotNull
	private String userName;
	@Email(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$", message = "Email should be in the format abc@gmail.com")
	private String userEmail;
	@NotEmpty(message = "FullName can not be Empty")
	@NotNull
	private String fullName;
	private LocalDate userDob;
	@NotEmpty(message = "Password can not be Empty")
	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
	@JsonIgnoreProperties
	private String password;
}
