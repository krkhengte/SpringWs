package jfs.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring_Bean.xml");
		
		BillCollector bc=ac.getBean("billCollector", BillCollector.class);
		bc.collectPayment(100000);
		
	}

}
