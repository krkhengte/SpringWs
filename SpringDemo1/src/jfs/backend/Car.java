package jfs.backend;

public class Car {

	public void drive() {
		
		Engine eng=new Engine();
		int str = eng.start(); // to get return type of method shortcut is (ctrl + 1 + enter)
		
		if(str>=1) {
			System.out.println("Jurney Started..");
		}else {
			System.out.println("Engine have some Issue..");
		}
		
	}
}
