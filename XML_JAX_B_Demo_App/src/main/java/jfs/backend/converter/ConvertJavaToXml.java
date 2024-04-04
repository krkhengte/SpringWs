package jfs.backend.converter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jfs.backend.binding.Person;

public class ConvertJavaToXml {

	public static void main(String[] args) throws Exception {
		
		Person person=new Person();
		
		person.setAge(30);
		person.setId(101);
		person.setName("Kartik");
		person.setPhNo(9172487618l);
		
		JAXBContext newInstance = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = newInstance.createMarshaller();
		marshaller.marshal(person,new File("Person.xml"));
		
		System.out.println("Marshalling Completed...");
		
	}
	
}
