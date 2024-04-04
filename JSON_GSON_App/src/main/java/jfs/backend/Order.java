package jfs.backend;

import lombok.Data;

@Data
public class Order {

	private Integer obderId;
	private String orderBy;
	private String orderStatus;
	private Double orderAmmount;
	
	
}
