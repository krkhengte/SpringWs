package jfs.backend.bms.booking.service.entity;

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
