package jfs.backend.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LambdaExpressionExample {

	public void run(Test4 t) {

		System.out.println("Passing functionality as a method argument");
	}

	public void show(Test5 t) {

	}

	public void add(Employee e) {

		System.out.println("Employee Id :" + e.getEmpId());
		System.out.println("Employee Name :" + e.getEmpName());

	}

	public static void main(String[] args) {

		LambdaExpressionExample lp = new LambdaExpressionExample();

		Employee e1 = new Employee();
		e1.setEmpId(101);
		e1.setEmpName("Kartik");

		lp.add(e1);

		lp.run(() -> System.out.println("Lambda Function")); // Passing the functionality as a method arguments

		List<Integer> intList = new ArrayList<Integer>();

		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(30);

		// System.out.println(lp.addition(intList));

		 int sum=intList.stream().reduce(0,(a,b)-> a+b);

		// int sum=intList.stream().mapToInt(Integer::intList).sum();

		//int sum = Employee.addition(intList);

		System.out.println("Sum Of total Number is: " + sum);

		BiFunction<Integer, Integer, Integer> bf = (x, y) -> {

			int z = x + y;

			System.out.println("The Addition of Two Numbers :" + z);

			return z;

		};

		bf.apply(5, 7);

		Supplier<String> su = () -> {

			return "Welcome to Java 8";
		};
		System.out.println("Supplier Method :" + su.get());

	}
}
