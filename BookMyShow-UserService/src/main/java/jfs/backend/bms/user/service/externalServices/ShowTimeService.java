package jfs.backend.bms.user.service.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.user.service.entity.ShowTimeDto;



@FeignClient("SHOWTIME-SERVICE")
public interface ShowTimeService {

	@GetMapping("showTime/showTime/getShowTimeById/{showTimeId}")
	public ShowTimeDto getShowTimeById(@PathVariable("showTimeId") String showTimeId);	
}
