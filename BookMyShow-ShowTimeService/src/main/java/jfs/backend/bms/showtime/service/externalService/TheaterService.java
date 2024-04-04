package jfs.backend.bms.showtime.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.showtime.service.entity.TheaterDto;

@FeignClient("THEATER-SERVICE")
public interface TheaterService {

	@GetMapping("theaters/getTheaterDetailsById/{theaterId}")
	public TheaterDto getTheaterById(@PathVariable String theaterId);
	
}
