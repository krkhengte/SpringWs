package jfs.backend.java8;

public interface Test {

	public void display();
	
	default void show() {            
		
		System.out.println("Deafult method in test interface");
	}
	
	static void add() {
		
		System.out.println("static method in test interface");
	}
	
}
