package jfs.backend.java8.collectionenhancement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperation2 {

	public static void main(String[] args) {

		LocalDateTime startTime = null;
		LocalDateTime endTime = null;

		List<String> strList = new ArrayList<String>();

		strList.add("Sangam");
		strList.add("Kartik");
		strList.add("Sangam");
		strList.add("Yogesh");
		strList.add("Kartik");
		strList.add("Kiran");
		strList.add("Yogesh");
		strList.add("Shubham");
		strList.add("Shubham");

		// Count the repeating the string elements

		Map<String, Long> collect = strList.stream().collect(Collectors.groupingBy((p) -> p, Collectors.counting()));
		System.out.println(collect);

		List<Employees> empList = new ArrayList<>();

		empList.add(new Employees(101, "kartik", 250000));
	//	empList.add(new Employees(101, "kartik1", 250000));
		empList.add(new Employees(102, "Sagar", 650000));	
		empList.add(new Employees(103, "Shubham", 750000));
		empList.add(new Employees(104, "Yogesh", 850000));
		empList.add(new Employees(105, "karan", 850000));
		empList.add(new Employees(106, "Arpit", 1050000));

		Map<Integer, Long> collect4 = empList.stream()
				.collect(Collectors.groupingBy((p) -> p.getEmpId(), Collectors.counting()));

		System.out.println(collect4);

		Map<String, Long> collect2 = empList.stream()
				.collect(Collectors.groupingBy((p) -> p.getEmpName(), Collectors.counting()));

		System.out.println(collect2);

		Map<Double, Long> collect3 = empList.stream()
				.collect(Collectors.groupingBy((p) -> p.getEmpSalary(), Collectors.counting()));

		System.out.println(collect3);
		
		
		Map<Integer, Double> collect7 = empList.stream().filter((p)->p.getEmpSalary()>25000).collect(Collectors.toMap((p1)->p1.getEmpId(), (p2)->p2.getEmpSalary()));
		System.out.println("After Convert Map form List:"+collect7);

		// find average salary

		IntSummaryStatistics collect5 = empList.stream().collect(Collectors.summarizingInt((p) -> p.getEmpId()));

		System.out.println("Int Operations :" + collect5);

		DoubleSummaryStatistics d = empList.stream().collect(Collectors.summarizingDouble((p) -> p.getEmpSalary()));

		System.out.println(d);

		System.out.println("Average" + d.getAverage());
		System.out.println("Min" + d.getMin());
		System.out.println("Max" + d.getMax());

		// find the second largest elements in the list

		empList.stream().sorted(Comparator.comparingDouble(Employees::getEmpSalary).reversed()).limit(2).skip(1)
				.forEach((x) -> System.out.println(x.getEmpSalary()));

		// or

		empList.stream().sorted(Comparator.comparingDouble(Employees::getEmpSalary).reversed()).skip(1)
				.forEach((x) -> System.out.println("Second Hoghest Salary :" + x.getEmpSalary()));

		List<String> l1 = new ArrayList<>();

		l1.add("Kartik");
		l1.add("Shubham");

		List<String> l2 = new ArrayList<>();

		l2.add("Yogesh");
		l2.add("Kiran");

		List<List<String>> l3 = new ArrayList<>();

		l3.add(l1);
		l3.add(l2);

		List<String> collect6 = l3.stream().flatMap((p) -> p.stream()).collect(Collectors.toList());

		System.out.println("New String List :" + collect6);

		System.out.println("******************************************************************");

		System.out.println("Start performing operation on list");

		startTime = LocalDateTime.now();

		System.out.println("Start Time :" + startTime);

		empList.stream().map((p) -> p.getEmpName()).forEach((p) -> System.out.println(p));
		endTime = LocalDateTime.now();
		System.out.println("End performing operation on list :" + endTime);
		Duration d1 = Duration.between(startTime, endTime);
		System.out.println("The Time will taken between the start and End Process :" + d1.toMillis());

		System.out.println("******************************************************************");

		System.out.println("Start performing parallel stream operation on list");
		startTime = LocalDateTime.now();

		// empList.parallelStream().map((p)->
		// p.getEmpName()).forEach((p)->System.out.println(p));

		// for getting the insertion order we can use forEach order

		System.out.println("*****************After using For Each ordered*******************");

		empList.parallelStream().map((p) -> p.getEmpName()).forEachOrdered((p) -> System.out.println(p));
		endTime = LocalDateTime.now();

		System.out.println("End performing parallel stream operation on list:" + endTime);
		Duration d2 = Duration.between(startTime, endTime);
		System.out.println("The Time will taken between the start and End Process :" + d2.toMillis());

	}

	private static Duration between(LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
