package jfs.backend.bms.food.service.Service;

import java.util.List;

import jfs.backend.bms.food.service.payload.FoodDto;

public interface FoodService {
	
	public FoodDto addFood(FoodDto foodDto);
	
	public List<FoodDto> getAllFood();
	
	public FoodDto updateFood(String foodId,FoodDto foodDto);
	
	public String deleteFood(String foodId);
	
	public FoodDto getFoodById(String foodId);

}
