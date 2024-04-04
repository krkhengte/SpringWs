package jfs.backend.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example1 {

	public static void main(String[] args) {

		// if we are using lambda expression we don't need to implements that interface

		Test t = () -> System.out.println("overridden display method inside the Example1 class"); // Lambda Expression
		t.display();

		Test2 t1 = (x) -> x;
		System.out.println("integer value is :" + t1.add(5));

		Test3 t3 = (a) -> a;
		System.out.println(t3.display("Welcome Kartik"));

		// Function Interface

		Function<Integer, Integer> r = (m) -> {

			System.out.println(m);
			return m;

		};

		r.apply(10);

		// Consumer Interface

		Consumer<String> consumer = (o) -> {

			System.out.println(o);
		};

		consumer.accept("Welcome To Java 8");

		// Supplier Interface

		Supplier<String> supplier = () -> {

			return "Java 8 Features";
		};

		System.out.println(supplier.get());

		// Predicate Interface

		Predicate<Integer> predicate = (n) -> n % 2 == 0;

		boolean test = predicate.test(10);

		if (test == true)
			System.out.println("The Given Number is Even Number");
		else
			System.out.println("The Given number is odd number");


	}
	
	

}
