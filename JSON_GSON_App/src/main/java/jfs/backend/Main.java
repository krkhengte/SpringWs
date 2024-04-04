package jfs.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Main {

	 public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		
			Order order=new Order();
			
			order.setObderId(101);
			order.setOrderBy("Rajesh");
			order.setOrderStatus("Confirmed");
			order.setOrderAmmount(1000.00);
		
			Gson gson=new Gson();
			String json = gson.toJson(order); // Convert Java object into JSON format 
			System.out.println(json);
			
			/*
			 * Order order2 = gson.fromJson(new FileReader("order.json"), Order.class); //
			 * Convert Json data to Java Obejct System.err.println(order2);
			 */
			
	}
}
