package jfs.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	
	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring_Bean.xml");// it used to start the IOC Container
		
		
		
		Motor m1=ac.getBean("motor", Motor.class);// Same Hashcode
		System.out.println(m1.hashCode());
		
		Motor m2=ac.getBean("motor", Motor.class); // Same Hashcode
		System.out.println(m2.hashCode());
		
		
		Car c=ac.getBean("car", Car.class);
		System.out.println("Car HashCode "+c.hashCode());
		
		// Because the Default Scope of Bean is Singleton(It Means The IOC Container will Create Only One Object) 
		
		
	}		

}
