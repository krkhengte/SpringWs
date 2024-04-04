package jfs.backend.java8.collectionenhancement;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {

		List<Employees> empList = new ArrayList<>();

		empList.add(new Employees(101, "kartik", 250000));
	//	empList.add(new Employees(101, "kartik1", 250000));
		empList.add(new Employees(102, "Sagar", 650000));
		empList.add(new Employees(103, "Shubham", 750000));
		empList.add(new Employees(104, "Yogesh", 850000));
		empList.add(new Employees(105, "karan", 850000));
		empList.add(new Employees(106, "Arpit", 1050000));

		// getting all empName which start with K with using for loop

		for (int i = 0; i < empList.size(); i++) {

			if (validate(empList.get(i).getEmpName())) {

				System.out.println(empList.get(i).getEmpName());

			}

		}
		
	//	System.out.println(empList);
		
		// write a program to create a list which contains employee name whose name starting with S
	    List<String> collect = empList.stream().filter((p)-> p.getEmpName().startsWith("S")).map((y)->y.getEmpName()).collect(Collectors.toList());
		
		System.out.println("**********Start with S **********");
		
		System.out.println(collect);
	

		// to convert the given employee list into map list 
		
		System.out.println("*****************New Converted Map List ****************");
		
		Map<Integer, Employees> map1 = empList.stream().collect(Collectors.toMap((p)->p.getEmpId(),(p)->p));
		
		System.out.println(map1);
		
		
	
		
		// find duplicate values

		System.out.println("************Distinct Employee**********");

		empList.stream().distinct().forEach((y) -> System.out.println(y));

		// find the max salary of employee
		Employees employees = empList.stream()
				.max((t1, t2) -> (t1.getEmpSalary() < t2.getEmpSalary() ? -1 : (t1 == t2) ? 0 : 1)).get();

		System.out.println("Maximum Salary of Employee :" + employees.getEmpName());
		System.out.println("Maximum Salary is :" + employees.getEmpSalary());

		// getting all empName which start with K with using stream

		System.out.println("Using Stream Api");

		empList.stream().filter((x) -> x.getEmpName().startsWith("k"))
				.forEach((y) -> System.out.println(y.getEmpName()));

		// get all the employee name and create a new String list

		List<String> empnameList = empList.stream().map((m) -> m.getEmpName()).collect(Collectors.toList());

		System.out.println("New List of Employee Name" + empnameList);

		// create a new New Integer list and find the even number

		List<Integer> intList = new ArrayList<>();
		intList.add(16);
		intList.add(22);
		intList.add(35);
		intList.add(42);
		intList.add(53);
		intList.add(60);
		intList.add(42);
		intList.add(53);
		intList.add(60);

		intList.stream().filter((x) -> x % 2 == 0).forEach((y) -> System.out.println(y));

		// find the max and min number

		int minVal = intList.get(0);
		int maxVal = intList.get(0);

		for (int i = 1; i < intList.size(); i++) {

			if (intList.get(i) < minVal) {

				minVal = intList.get(i);
			}

			if (intList.get(i) > maxVal) {
				maxVal = intList.get(i);
			}
		}
		System.out.println("The Minimum value is :" + minVal);
		System.out.println("The Maximum value is :" + maxVal);

		// remove the duplicate element

		System.out.println("Before the removing duplicate elements :" + intList);
		intList.stream().distinct().forEach((x) -> System.out.println("After removing duplicate elements:" + x));

		// count number of duplicate elements

		int duplicateElementsCount = (int) (intList.size() - intList.stream().distinct().count());

		System.out.println("The Duplicate Elements Count is :" + duplicateElementsCount);

		// sort the nunbers by assending

		System.out.println("Assensing Order :" + intList.stream()
				.sorted((t1, t2) -> (t1 < t2) ? -1 : ((t1 == t2) ? 0 : 1)).collect(Collectors.toList()));
		System.out.println("Descending Order :" + intList.stream()
				.sorted((t1, t2) -> (t1 < t2) ? +1 : ((t1 == t2) ? 0 : -1)).collect(Collectors.toList()));

		// find the max and min number using java 8
		intList.stream().min((t1, t2) -> (t1 < t2) ? -1 : (t1 == t2) ? 0 : 1);

		System.out
				.println("Min Number :" + intList.stream().min((t1, t2) -> (t1 < t2) ? -1 : (t1 == t2) ? 0 : 1).get());
		System.out
				.println("Max Number :" + intList.stream().max((t1, t2) -> (t1 < t2) ? -1 : (t1 == t2) ? 0 : 1).get());

		
		// find the second highest elements in the list
		
		intList.stream().sorted(Collections.reverseOrder()).limit(3).skip(2).forEach((s)->System.err.println("Second Highest Number :" +s));
		
		// find the second smallest elements in the list
		
		intList.stream().sorted().limit(2).skip(1).forEach((v)->System.out.println("Second Smallest Number :" + v));
		
		System.out.println(intList.stream().findFirst());
		System.out.println(intList.stream().findAny());
		
		
	}

	static boolean validate(String s) {

		if (s.startsWith("k")) {
			return true;

		} else {
			return false;
		}

	}
	
	

}
