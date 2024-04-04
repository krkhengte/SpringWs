package jfs.backend.bms.payment.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.payment.service.entity.UserDto;



@FeignClient("USER-SERVICE")
public interface UserService {

	@GetMapping("users/getSingleUser/{userId}")
	public UserDto getSingleUser(@PathVariable("userId") String userId);
}
