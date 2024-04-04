package jfs.backend.bms.booking.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jfs.backend.bms.booking.service.entity.FoodDto;

@FeignClient("FOOD-SERVICE")
public interface FoodService {
	
	@GetMapping("foods/getFoodByID/{foodId}")
	public FoodDto getFoodById(@PathVariable String foodId);

}
