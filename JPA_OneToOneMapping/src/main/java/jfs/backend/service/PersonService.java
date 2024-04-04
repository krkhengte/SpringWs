package jfs.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import jfs.backend.entity.Address;
import jfs.backend.entity.Person;
import jfs.backend.repository.PersonRepository;

@Service
public class PersonService {

	
	@Autowired
	private PersonRepository personRep;

	public void addPersonInfo() {
		
		Person person = new Person();
		Address address = new Address();

		// address.setAId(10);
		address.setCity("Delhi");
		address.setState("Delhi");
		address.setCountry("India");
		address.setPerson(person);

		// person.setPId(103);
		person.setName("Arpit");
		person.setAge(28);
		person.setGender("Male");
		person.setAddress(address);

		personRep.save(person);

		System.out.println("Record Inserted");
		
		Optional<Person> findById = personRep.findById(1);
		
		Person p1 = findById.get();
		Address adr = p1.getAddress();
		System.out.println("Name : " +p1.getName());
		System.out.println("City : "+adr.getCity());
		System.out.println("State : "+adr.getState());
		System.out.println("Country : "+adr.getCountry());
		
	}

}
