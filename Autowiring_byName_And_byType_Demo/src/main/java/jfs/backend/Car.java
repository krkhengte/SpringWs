package jfs.backend;

public class Car {
	
	private DieselEngine dieselEng;
	
	/*
	 * public void setDieselEng(DieselEngine dieselEng) { this.dieselEng =
	 * dieselEng; }
	 */
	
	// if you want to use Autowiring by constructor
	
	

	public Car(DieselEngine dieselEng) {
		super();
		this.dieselEng = dieselEng;
		System.out.println("Car :: arg Constructor");
	}

	public Car() {
		System.out.println("Car :: 0 arg Constructor");
	}
	
	public void drive() {
		
		int start = dieselEng.start();
		
		if(start>=1) {
			
			System.out.println("Jurney Started....");
		}else {
			
			System.out.println("Engine Failed to Start");
		}
		
	}

}
