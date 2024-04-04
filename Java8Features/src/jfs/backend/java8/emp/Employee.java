package jfs.backend.java8.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jfs.backend.java8.collectionenhancement.Employees;

public class Employee {

	public Employee(int empId, String empName, double empSalary, int year) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.year = year;
	}

	private int empId;
	private String empName;
	private double empSalary;
	private int year;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", year=" + year
				+ "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee(101, "Kartik", 500000, 5));
		empList.add(new Employee(102, "Kartik", 300000, 3));
		empList.add(new Employee(103, "Kartik", 500000, 5));
		empList.add(new Employee(104, "Kartik", 200000, 2));
		empList.add(new Employee(105, "Kartik", 400000, 4));
		empList.add(new Employee(106, "Kartik", 400000, 4));
		empList.add(new Employee(107, "Kartik", 500000, 5));
		empList.add(new Employee(108, "Kartik", 700000, 7));
		empList.add(new Employee(109, "Kartik", 300000, 3));

		empList.stream().map((x) -> {
			if (x.getYear() >= 5) {
				x.setEmpSalary(x.getEmpSalary() * 0.1 + x.getEmpSalary());
				return x;
			}

			return x;

		}).forEach((s) -> System.out.println(s));

	}

}
