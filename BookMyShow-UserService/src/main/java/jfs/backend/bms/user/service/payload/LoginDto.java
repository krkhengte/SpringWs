package jfs.backend.bms.user.service.payload;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {

	@NotEmpty(message = "Username cannot be empty")
	@NotNull
	private String userName;

	@NotEmpty(message = "password cannot be empty")
	@NotNull
	private String password;
}
