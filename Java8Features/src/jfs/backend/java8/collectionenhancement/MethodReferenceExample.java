package jfs.backend.java8.collectionenhancement;

import jfs.backend.java8.Test;

public class MethodReferenceExample {

	public static void main(String[] args) {

		// method reference for static method

		Test t1=MethodReferenceExample::show;
		t1.show();
		
	

	}

	public static void show() {
		
		System.out.println("Static show method");
	}
	
	public static boolean display() {

		int x = 5;
		int z = 10;

		if (x > z)
			return true;
		else
			return false;

	}

}
