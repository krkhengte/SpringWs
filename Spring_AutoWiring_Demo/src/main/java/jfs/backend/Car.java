package jfs.backend;

public class Car {

	private DieselEngine disEng;

	public void setDisEng(DieselEngine disEng) {
		this.disEng = disEng;
	}

	public Car() {
		System.out.println("Car :: Cunstructor");
	}

	public void drive() {
		int str = disEng.start();

		if (str >= 1) {
			System.out.println("Journey Started");
		} else {
			System.out.println("Engine Failed To Start..");
		}
	}

}
