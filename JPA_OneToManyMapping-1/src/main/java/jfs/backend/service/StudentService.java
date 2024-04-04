package jfs.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.Address;
import jfs.backend.entity.Student;
import jfs.backend.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRep;
	
	public void addStudentInfo() {
		
		Student student=new Student();
		
		Address a1=new Address();
		
		a1.setCity("Pune");
		a1.setState("Maharashtra");
		a1.setCountry("India");
		a1.setStudent(student);

		Address a2=new Address();
		
		a2.setCity("Delhi");
		a2.setState("Delhi");
		a2.setCountry("India");
		a2.setStudent(student);
		
		List<Address> addreseList=new ArrayList();
		addreseList.add(a1);
		addreseList.add(a2);
		
		student.setName("Kartik");
		student.setGender("Male");
		student.setAge(22);
		student.setAddress(addreseList);
		
		//studentRep.save(student);
		
		System.out.println("Record Inserted...");
		
		Optional<Student> findById = studentRep.findById(2);
		
		Student s1 = findById.get();
		List<Address> adr = s1.getAddress();
		
		System.out.println("Name :" + s1.getName());
		Address address1 = adr.get(0);
		Address address2 = adr.get(1);
		
		System.out.println("First Address");
		
		System.out.println("City Name :" +address1.getCity());
		System.out.println("State Name :" +address1.getState());
		System.out.println("Country Name :" +address1.getCountry());
		
		System.out.println("Second Address");
		
		System.out.println("City Name :" +address2.getCity());
		System.out.println("State Name :" +address2.getState());
		System.out.println("Country Name :" +address2.getCountry());
		
		
	}
}
