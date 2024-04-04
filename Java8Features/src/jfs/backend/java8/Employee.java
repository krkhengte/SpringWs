package jfs.backend.java8;

import java.util.List;

public class Employee {

	private int empId;
	private String empName;
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

	public static Integer addition(List<Integer> list) {
		
		return list.stream().reduce(0, Integer::sum);
	}
	
}
