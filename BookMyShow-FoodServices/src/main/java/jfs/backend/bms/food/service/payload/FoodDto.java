package jfs.backend.bms.food.service.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

	private String foodId;
	private String foodName;
	private Integer foodQnt;
	private Double foodPrice;
}
