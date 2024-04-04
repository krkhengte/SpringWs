package jfs.backend.java8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course {

	private String CourceName;

	@Override
	public String toString() {
		return "Course [CourceName=" + CourceName + ", duration=" + duration + "]";
	}

	private int duration;

	public String getCourceName() {
		return CourceName;
	}

	public void setCourceName(String courceName) {
		CourceName = courceName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Course(String courceName, int duration) {
		super();
		CourceName = courceName;
		this.duration = duration;
	}

}

class Student {

	@Override
	public String toString() {
		return "Student [stRoll=" + stRoll + ", stName=" + stName + ", age=" + age + ", gender=" + gender
				+ ", subscribeCourse=" + subscribeCourse + "]";
	}

	private int stRoll;
	private String stName;
	private int age;
	private String gender;

	private List<Course> subscribeCourse;

	public Student(int stRoll, String stName, int age, String gender, List<Course> subscribeCourse) {
		super();
		this.stRoll = stRoll;
		this.stName = stName;
		this.age = age;
		this.gender = gender;
		this.subscribeCourse = subscribeCourse;
	}

	public int getStRoll() {
		return stRoll;
	}

	public void setStRoll(int stRoll) {
		this.stRoll = stRoll;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Course> getSubscribeCourse() {
		return subscribeCourse;
	}

	public void setSubscribeCourse(List<Course> subscribeCourse) {
		this.subscribeCourse = subscribeCourse;
	}

}

public class Practice1 {

	public static void main(String[] args) {

		List<Course> courses1 = new ArrayList<>();
		courses1.add(new Course("JavaFullStack", 5));
		courses1.add(new Course("Python Developers", 7));
		courses1.add(new Course("Data Engineear", 4));

		List<Course> courses2 = new ArrayList<>();
		courses2.add(new Course("MernStackDevelopeers", 7));
		courses2.add(new Course("Data Science Engineear", 5));

		List<Course> courses3 = new ArrayList<>();
		courses3.add(new Course("MernStackDevelopeers", 7));
		courses3.add(new Course("JavaFullStack", 5));
		courses3.add(new Course("Data Science Engineear", 5));

		List<Course> courses4 = new ArrayList<>();
		courses4.add(new Course("C++ Developer", 4));
		courses4.add(new Course("FrontEnd Developer", 4));

		List<Student> studList = new ArrayList<>();

		studList.add(new Student(101, "Kartik", 22, "Male", courses1));
		studList.add(new Student(102, "Yogesh", 28, "Male", courses1));
		studList.add(new Student(103, "Shubhangi", 27, "Female", courses3));
		studList.add(new Student(104, "Kiran", 27, "Female", courses2));
		studList.add(new Student(105, "Arpit", 30, "Male", courses4));
		studList.add(new Student(106, "Vishal", 32, "Male", courses4));
		studList.add(new Student(107, "Akshay", 28, "Male", courses3));
		studList.add(new Student(108, "Sonali", 24, "Female", courses1));
		studList.add(new Student(109, "Sai", 22, "Male", courses3));
		studList.add(new Student(110, "Sangam", 22, "Male", courses4));

		// 1. Make a list all Male students

		 List<Student> collect = studList.stream().filter((x)->x.getGender().equals("Male")).map((p)->p).collect(Collectors.toList());

		 System.out.println(collect);
		 
		 // 2. Make a list of names of all Female student's with age less than 25yrs 
		 
		 System.out.println("Make a list of names of all Female student's with age less than 25yrs");
		 
		 List<Student> collect2 = studList.stream().filter((x)->x.getGender().equals("Female") && x.getAge()<25).map((p)->p).collect(Collectors.toList());

		 System.out.println(collect2);
		 
		 
		 
		 // 3. Update age of all students by 2yrs
		 
	//	 studList.stream().filter((y)->y.getAge()+2).map((x)->x).collect(Collectors.toList());
		 
		 
		 
	}

}
