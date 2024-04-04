package jfs.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring_Bean.xml");
		
		Car car=ac.getBean("car", Car.class);
		car.drive();
		
	}

}
