package jfs.backend.java8.collectionenhancement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionEnhancements {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		// int sum=0;

		System.out.println("Data iterating using for loop");

		for (int i = 0; i < list.size(); i++) {

			// sum +=list.get(i);

			System.out.println(list.get(i));

			// System.out.println(sum);

		}

		System.out.println("Data iterating using for each loop with lambda expression");

//		Consumer<Integer> c=(y)->System.out.println(y);
//		
//		list.forEach(c);

		// simple way

		list.forEach((x) -> System.out.println(x));

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Kartik", 250000));
		empList.add(new Employee(102, "Sagar", 650000));
		empList.add(new Employee(103, "Shubham", 750000));
		empList.add(new Employee(104, "Yogesh", 850000));
		empList.add(new Employee(105, "Arpit", 1050000));

		for (int i = 0; i < empList.size(); i++) {

			System.out.println("Emp Id :" + empList.get(i).getEmpId());
			System.out.println("Emp Name :" + empList.get(i).getEmpName());
			System.out.println("Emp Salary :" + empList.get(i).getEmpSalary());

		}

		System.out.println("Data iterating using for each loop with lambda expression");

		empList.forEach((x) -> System.out.println(
				"Emp Id :" + x.getEmpId() + "Emp Name :" + x.getEmpName() + "Emp Salary :" + x.getEmpSalary()));

		empList.stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)
				.reversed()).limit(3).skip(2)
				.forEach((x) -> System.out.println("Highest Third Salary :" + x.getEmpSalary()));
		


//		 System.out.println(descOrder);
//		 
//		 descOrder.stream().limit(3).skip(2).forEach((x)->System.out.println(x.getEmpSalary()));	 
//		

		// descOrder.forEach((a)->System.out.println(a.getEmpSalary()));

	}

}
